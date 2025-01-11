package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TestFeline {
    private final int kittensCount;
    private Feline feline;


    public TestFeline(int kittensCount){
        this.kittensCount = kittensCount;
    }
    @Parameterized.Parameters
    public static Object[][] testCases() {
        return new Object[][]{
                {1},
                {2},
                {5}
        };
    }

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void getFamilyTest() {
        String actualAnswer = feline.getFamily(); // Фактическое значение
        String expectedAnswer = "Кошачьи"; // Ожидаемое значение
        assertEquals(expectedAnswer, actualAnswer); // Проверяем соответствие
    }

    @Test
    public void getKittensWithoutArgumentTest() {
        int actualAnswer = feline.getKittens(); // Фактическое значение
        int expectedAnswer = 1; // Ожидаемое значение
        assertEquals(expectedAnswer, actualAnswer); // Проверяем соответствие
    }
    @Test
    public void getKittensWithArgumentTest() {
        int actualAnswer = feline.getKittens(kittensCount); // Фактическое значение
        int expectedAnswer = kittensCount; // Ожидаемое значение
        assertEquals(expectedAnswer, actualAnswer); // Проверяем соответствие
    }
    @Test
    public void eatMeatTest() throws Exception {

        List<String> expectedFood = Arrays.asList("Мясо", "Курица", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }
}

package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TestLion {

    private Lion lion;
    private Feline felineInMock;
    private final String sex; // Пол льва
    private final boolean expectedAnswer; // Ожидаемое значение наличия гривы

    public TestLion(String sex, boolean expectedAnswer) {
        this.sex = sex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] testCases() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex,felineInMock);
        boolean actualAnswer = lion.doesHaveMane();
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Test
    public void testGetFood() throws Exception {
        felineInMock = Mockito.mock(Feline.class);
        lion = new Lion("Самец", felineInMock);
        List<String> expectedFood = Arrays.asList("Мясо", "Курица", "Рыба");
        when(felineInMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineInMock, Mockito.times(1)).getFood("Хищник");
    }
}

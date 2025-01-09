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
public class TestLionn {

    private Lionn lionn;
    private FelineIn felineInMock;
    private final String sex; // Пол льва
    private final boolean expectedAnswer; // Ожидаемое значение наличия гривы

    public TestLionn(String sex, boolean expectedAnswer) {
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
        Lionn lionn = new Lionn(sex);
        boolean actualAnswer = lionn.doesHaveMane();
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Test
    public void testGetFood() throws Exception {
        felineInMock = Mockito.mock(FelineIn.class);
        lionn = new Lionn("Самец", felineInMock);
        List<String> expectedFood = Arrays.asList("Мясо", "Курица", "Рыба");
        when(felineInMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lionn.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineInMock, Mockito.times(1)).getFood("Хищник");
    }
}

package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionAlexTest {
    private LionAlex alex;


    @Before
    public void setUp() throws Exception {
        alex = new LionAlex();
    }


    @Test
    public void testGetFriends() throws Exception {

        List<String> actualAnswer = alex.getFriends();
        assertEquals(List.of("Марти", "Мелман", "Глория", "Практикум"), actualAnswer);
    }

    @Test
    public void testgetPlaceOfLiving() throws Exception {

        String actualAnswer = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actualAnswer);
    }

    @Test
    public void testgetKittens() throws Exception {

        int actualAnswer = alex.getKittens();
        assertEquals(0, actualAnswer);
    }

}

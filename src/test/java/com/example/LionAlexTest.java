package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {
    private LionAlex alex;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {

        felineMock = Mockito.mock(Feline.class);

        alex = new LionAlex(felineMock);
    }

    @Test
    public void testGetFriends() {
        List<String> actualAnswer = alex.getFriends();
        assertEquals(List.of("Марти", "Мелман", "Глория", "Практикум"), actualAnswer);
    }

    @Test
    public void testGetPlaceOfLiving() {
        String actualAnswer = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actualAnswer);
    }

    @Test
    public void testGetKittens() {
        int actualAnswer = alex.getKittens();
        assertEquals(0, actualAnswer);
    }
}

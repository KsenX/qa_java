package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {
    @Spy
    Feline feline = new Feline();

    @Test
    public void testGetFamily() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");

    }

    @Test
    public void testGetKittens() {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void testGetKittensSeveral() {
        int expectedResult = 3;
        int actualResult = feline.getKittens(3);
        assertEquals(expectedResult, actualResult);
    }
}
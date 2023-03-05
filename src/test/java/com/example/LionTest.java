package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTest extends TestCase {
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getManeLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };

    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Feline feline = new Feline();
    Feline felineSpy = Mockito.spy(feline);


    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(felineSpy, "Самка");
        lion.getKittens();
        Mockito.verify(felineSpy).getKittens();
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(hasMane, actualResult);

    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(felineSpy, "Самка");
        lion.getFood();
        Mockito.verify(felineSpy).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testIncorrectSexThrowsException() throws Exception {
        Lion lion = new Lion(felineSpy, "ЭксепшенВыбросит");

    }
}
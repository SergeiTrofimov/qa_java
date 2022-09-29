package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

Feline feline = new Feline();

    Cat cat = new Cat(feline);
    @Test
    public void getSoundTest() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }
    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
    }
}
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void getEatMeatTest() throws Exception
    {
        List<String> actual=feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyTest()
    {
     String actual = feline.getFamily();
     String expected = "Кошачьи";
     assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensIntTest() {
        int actual = feline.getKittens(1);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    Feline feline = new Feline(); // создаем объект класса feline

    @Test
    public void getEatMeatTest() throws Exception // проверяем метод getEatMeat
    {
        List<String> actual=feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyTest() // проверяем метод getFamily
    {
     String actual = feline.getFamily();
     String expected = "Кошачьи";
     assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() { // проверяем метод getKittens
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensIntTest() { // проверяем метод getKittens(параметризуемый)
        int actual = feline.getKittens(1);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
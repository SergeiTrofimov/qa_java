package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline; // мокируем feline
    @Spy
    private Cat cat = new Cat(feline); // следим за объетом Car

    @Test
    public void getSoundTest() { // проверяем метод getSound
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception { // проваеряем метод getFood. проверяем что вызывается метод другого класса eatMeat
        Cat cat = Mockito.spy(new Cat(feline));
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
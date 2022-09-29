package com.example;

import org.junit.Test;

import java.util.List;

public class FelineTest {
Feline feline = new Feline();

    @Test
    public void getEatMeatTest() throws Exception
    {
        List<String> actual=feline.eatMeat();
        List<String> expected = List.of("Трава", "Различные растения");

    }

    @Test
    public void getFamilyTest() {
    }

    @Test
    public void getKittensTest() {
    }

    @Test
    public void getKittensIntTest() {

    }
}

package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionTest {
    @Parameterized.Parameter(0)
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expected;
    @Mock
    Feline feline;

    @Parameterized.Parameters(name = "Проверка для пола, сейчас лев -{0}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Виталик", true}
        };

    }

    @Before
    public void mockitoInit() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        if(sex=="Самец"||sex=="Самка") {
            Lion lion = new Lion(sex, feline);
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        }
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void doesHaveManeTest() throws Exception {

        if(sex=="Самец"||sex=="Самка") {
            Lion lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        }
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }


    @Test
    public void getFoodTest() throws Exception {
        if (sex == "Самец" || sex == "Самка") {
            Lion lion = new Lion(sex, feline);
            lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        }
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
    }
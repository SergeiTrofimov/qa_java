package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionTest {
    @Parameterized.Parameter(0)
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expected;

    @Before
    public void mockitoInit(){
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                //{"Тварь", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };

    }

    @Test
    public void getKittensTest() throws Exception {
      Lion lion = new Lion("Самец",feline);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex,feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex,feline);
        System.out.println(lion.getFood());
    }
}
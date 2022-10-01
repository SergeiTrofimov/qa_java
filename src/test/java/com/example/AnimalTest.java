package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List<String> expected;

    public AnimalTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }
    Animal animal = new Animal();


    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Тварь", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };
    }
    @Test
    public void getFoodTest() throws Exception {
        if(animalKind=="Травоядное"||animalKind=="Хищник") {
            List<String> actual = animal.getFood(animalKind);
            assertEquals(expected, actual);
        }
        try {
            animal.getFood(animalKind);
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
    @Test
    public void getFamilyTest()
    {
    String actual=animal.getFamily();
    String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    assertEquals(expected, actual);
    }
}
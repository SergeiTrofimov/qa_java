package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind; // тип животного
    private final List<String> expected; // сюда передаем ожидаемый результат

    public AnimalTest(String animalKind, List<String> expected) { // конструктор класса
        this.animalKind = animalKind;
        this.expected = expected;
    }
    Animal animal = new Animal(); // создаем объект класса животное


    @Parameterized.Parameters (name = "Животное сейчас: {0}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Тварь", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };
    }
    @Test // тест метода getFood
    public void getFoodTest() throws Exception {
        if(animalKind=="Травоядное"||animalKind=="Хищник") {  // проверяем допустимые значения
            List<String> actual = animal.getFood(animalKind);
            assertEquals(expected, actual);
        }
        try { // ловим исключение, если передано недопустимые значения и проверяем оторажаемое сообщение
            animal.getFood(animalKind);
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
    @Test
    public void getFamilyTest() // проверяем метод getFamily
    {
    String actual=animal.getFamily();
    String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    assertEquals(expected, actual);
    }
}
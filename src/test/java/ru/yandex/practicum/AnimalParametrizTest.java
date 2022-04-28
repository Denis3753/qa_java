package ru.yandex.practicum;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParametrizTest {

    private final String animalKind;
    private final List<String> expected;

    public AnimalParametrizTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getDataFood() {

        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFood() throws Exception {

        Animal animal = new Animal();
        List<String> list = animal.getFood(animalKind);
        int actual = list.size();

        assertEquals(expected.size(), actual);
    }
}

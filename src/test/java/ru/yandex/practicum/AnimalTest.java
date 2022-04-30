package ru.yandex.practicum;

import com.example.Animal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    private static final String exceptMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private Animal animal;

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createInstanceAnimal() {
        animal = new Animal();
    }

    @Test
    public void getFoodCheckHerbivore() throws Exception{
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodCheckPredator() throws Exception{
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }


    @Test(expected = Exception.class)
    public void getFoodCheckException() throws Exception {
        List<String> list = animal.getFood("Всеядное");
    }

    @Test
    public void getFamily() {

        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        assertEquals(expected, actual);
    }
}

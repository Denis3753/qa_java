package ru.yandex.practicum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Before
    public void createInstanceCat() {
        cat = new Cat(feline);
    }

    @Mock
    private Feline feline;


    @Test
    public void getSound() {

        String actual = cat.getSound();
        String expected = "Мяу";

        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }
}

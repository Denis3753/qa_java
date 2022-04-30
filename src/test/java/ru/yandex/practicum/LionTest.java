package ru.yandex.practicum;

import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String genderMale = "Самец";
    private static final String genderFemale = "Самка";
    private static final String invalidGender = "Чудо в перышках";
    private static final String exceptionMessage = "Используйте допустимые значения пола животного - самей или самка";

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Feline feline;

    @Test
    public void getKittens() throws Exception {

        Lion lion = new Lion(genderMale, feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        int actual = lion.getKittens();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {

        Lion lionMale = new Lion(genderMale, feline);
        boolean actual = lionMale.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void doesNotHaveMane() throws Exception {

        Lion lionFemale = new Lion(genderFemale, feline);
        boolean actual2 = lionFemale.doesHaveMane();
        assertFalse(actual2);
    }

    @Test
    public void getFood() throws Exception {

        Lion lion = new Lion(genderMale, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void checkExceptionCreateLion() throws Exception {

        Lion lion = new Lion(invalidGender, feline);
    }
}

package ru.yandex.practicum;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizTest {

    private final String gender;
    private final boolean expected;

    public LionParametrizTest(String gender,boolean expected) {
        this.gender = gender;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] lionsCreateData() {
        return new Object[][] {

                {"Самец", true},
                {"Самка", false}
        };
    }

    @Mock
    Feline feline;

    @Test
    public void lionCreate() throws Exception {

        Lion lion = new Lion(gender, feline);
        boolean actual = lion.doesHaveMane();

        assertEquals(expected, actual);
    }
}

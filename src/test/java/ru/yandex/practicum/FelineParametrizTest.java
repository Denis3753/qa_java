package ru.yandex.practicum;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizTest {

    private final int kittensCount;
    private final int expected;

    public FelineParametrizTest(int kittensCount,int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensDataCount() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5}
        };
    }

    @Test
    public void getKittensCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);

        assertEquals(expected, actual);
    }
}

package it.sevenbits.packages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Parametrized test - easier to tes a lot of data in similar way
 */
@RunWith(Parameterized.class)
public class ParametrizedTest {
    private double a;
    private double b;
    private double c;
    private boolean expected;

    public ParametrizedTest(final double a, final double b, final double c, final boolean expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:triangle {0}, {1}, {2} exists: {3}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {3, 4, 5, true},
                {6, 8, 10, true},
                {5, 5, 5, false}
        });
    }

    @Test
    public void isRightTest() throws InvalidAttributeValueException {
        assertEquals(expected, new Triangle(a, b, c).isRight());
    }
}

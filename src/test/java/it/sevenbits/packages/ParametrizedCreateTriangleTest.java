package it.sevenbits.packages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Creating some triangles
 */
@RunWith(Parameterized.class)
public class ParametrizedCreateTriangleTest {
    private double a;
    private double b;
    private double c;
    private boolean expected;

    public ParametrizedCreateTriangleTest(final double a, final double b, final double c, final boolean expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:triangle {0}, {1}, {2} exists: {3}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {3, 4, 5, true},
                {2, 8, 14, false},
                {5, 5, 5, true},
                {0, 0, 0, false}
        });
    }

    @Test
    public void createTriangleTest() throws InvalidAttributeValueException {
        boolean actual = true;
        Triangle triangle = null;
        try {
            triangle = new Triangle(a, b, c);
        }
        catch (InvalidAttributeValueException e){
            actual = false;
        }
        assertEquals(expected, actual);
    }
}

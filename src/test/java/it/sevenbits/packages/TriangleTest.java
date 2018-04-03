package it.sevenbits.packages;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for triangle class
 */
public class TriangleTest {

    @Test
    public void createDefaultTriangleTest() {
        Triangle defaultTri = null;
        defaultTri = new Triangle();
        assertNotNull(defaultTri);
    }

    @Test
    public void copyTriangle() {
        Triangle tri1 = new Triangle();
        Triangle tri2 = new Triangle(tri1);
        assertEquals(tri1, tri2);
    }

    @Test
    public void toStringTest() {
        Triangle tri = new Triangle();
        assertEquals("a = 3.0, b = 3.0, c = 3.0", tri.toString());
    }
}
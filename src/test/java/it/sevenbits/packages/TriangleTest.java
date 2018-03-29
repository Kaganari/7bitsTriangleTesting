package it.sevenbits.packages;

import org.junit.Test;
import javax.naming.directory.InvalidAttributeValueException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing class, that describes a triangle
 */
public class TriangleTest {

    @Test
    public void createDefaultTriangleTest() {
        Triangle defaultTri = null;
        defaultTri = new Triangle();
        assertNotNull(defaultTri);
    }

    @Test
    public void createTriangleTest() throws InvalidAttributeValueException {
        Triangle existingTri = null;
        existingTri = new Triangle(5, 5, 5);
        assertNotNull(existingTri);
    }

    @Test
    public void createNonExistingTriangleTest() {
        Triangle nonExistingTri = null;
        try {
            nonExistingTri = new Triangle(2, 8, 14);
        } catch (InvalidAttributeValueException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(null, nonExistingTri);
    }

    @Test
    public void createRightTriangleTest() throws InvalidAttributeValueException {
        Triangle rightTri = null;
        rightTri = new Triangle(3, 4, 5);
        assertNotNull(rightTri);
    }

    @Test
    public void copyTriangle() {
        Triangle tri1 = new Triangle();
        Triangle tri2 = new Triangle(tri1);
        assertEquals(tri1, tri2);
    }

    @Test
    public void isRightTest() throws InvalidAttributeValueException {
        Triangle rightTri1 = new Triangle(3, 4, 5);
        Triangle rightTri2 = new Triangle(6, 8, 10);
        Triangle existingTri = new Triangle(5, 5, 5);
        assertEquals(true, rightTri1.isRight());
        assertEquals(true, rightTri2.isRight());
        assertEquals(false, existingTri.isRight());
    }

    @Test
    public void toStringTest() {
        Triangle tri = new Triangle();
        assertEquals("a = 3.0, b = 3.0, c = 3.0", tri.toString());
    }
}
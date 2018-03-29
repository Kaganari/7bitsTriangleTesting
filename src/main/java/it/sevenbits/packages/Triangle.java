package it.sevenbits.packages;

import javax.naming.directory.InvalidAttributeValueException;

/**
 * Class, describing a triangle
 */
public class Triangle {
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public Triangle() {
        a = b = c = 3;
    }

    public Triangle(final double a, final double b, final double c) throws InvalidAttributeValueException {
        if (canExist(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else
            throw new InvalidAttributeValueException("Such triangle can't exist in our dimension");
    }

    public Triangle(Triangle tri) {
        this.a = tri.getSide_a();
        this.b = tri.getSide_b();
        this.c = tri.getSide_c();
    }

    public double getSide_a() {
        return a;
    }
    public double getSide_b() {
        return b;
    }
    public double getSide_c() {
        return c;
    }

    @Override
    public String toString() {
        return "a = " + a + ", b = " + b + ", c = " + c;
    }

    private boolean canExist (final double a, final double b, final double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public boolean isRight() {
        boolean req_1 = (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) == c) &&
                        (Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2)) == a) &&
                        (Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2)) == b);

        boolean req_2 = (Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)) == a) &&
                        (Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2)) == b) &&
                        (Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2)) == c);

        boolean req_3 = (Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)) == b) &&
                        (Math.sqrt(Math.pow(b, 2) - Math.pow(c, 2)) == a) &&
                        (Math.sqrt(Math.pow(b, 2) - Math.pow(a, 2)) == c);

        return req_1 || req_2 || req_3;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Triangle && a == ((Triangle) obj).a && b == ((Triangle) obj).b && c == ((Triangle) obj).c);
    }
}

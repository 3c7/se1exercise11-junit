package org.bonn.se.ws14.geometry;

/**
 * Created by Nils on 16.01.2016.
 */
public class MyPoint {
    private double x, y;

    public MyPoint(double a, double b) {
        x = a;
        y = b;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }
    public void x(double a) {
        x = a;
    }

    public void y(double b) {
        y = b;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyPoint)) return false;
        MyPoint b = (MyPoint) o;
        return (x() == b.x() && y() == b.y());
    }
}

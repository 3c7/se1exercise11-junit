package org.bonn.se.ws14.geometry;

/**
 * Created by Nils on 16.01.2016.
 */
public class MyPrettyRectangle {
    private MyPoint ll, ur;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        ll = new MyPoint(x1, y1);
        ur = new MyPoint(x2, y2);
    }

    public boolean contains(MyPrettyRectangle rect) {
        return (getLL().x() <= rect.getLL().x() &&
                getLL().y() <= rect.getLL().y() &&
                getUR().x() >= rect.getUR().x() &&
                getUR().y() >= rect.getUR().y());
    }

    public MyPoint getLL() {
        return ll;
    }

    public MyPoint getUR() {
        return ur;
    }

    public MyPoint getCenter() {
        return new MyPoint(getLL().x() + (getUR().x() - getLL().x()) / 2, getLL().y() + (getUR().y() - getLL().y()) / 2);
    }

    public double getArea() {
        return (getUR().x() - getLL().x()) * (getUR().y() - getLL().y());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyPrettyRectangle)) return false;
        MyPrettyRectangle other = (MyPrettyRectangle) o;
        return getLL().equals(other.getLL()) && getUR().equals(other.getUR());
    }
}

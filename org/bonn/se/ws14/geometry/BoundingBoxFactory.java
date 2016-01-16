package org.bonn.se.ws14.geometry;

/**
 * Created by Nils on 16.01.2016.
 */
public class BoundingBoxFactory {
    public static MyPrettyRectangle createBB(MyPrettyRectangle[] rectArray) {
        MyPoint min = new MyPoint(Double.MAX_VALUE, Double.MAX_VALUE);
        MyPoint max = new MyPoint(Double.MIN_VALUE, Double.MIN_VALUE);

        for (MyPrettyRectangle rect : rectArray) {
            if (rect.getLL().x() < min.x())
                min.x(rect.getLL().x());
            if (rect.getLL().y() < min.y())
                min.y(rect.getLL().y());
            if (rect.getUR().x() > max.x())
                max.x(rect.getUR().x());
            if (rect.getUR().y() > max.y())
                max.y(rect.getUR().y());
        }

        return new MyPrettyRectangle(min.x(), min.y(), max.x(), max.y());
    }
}

package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Point;

public class SymmetryRotatePoint {
    private SymmetryRotatePoint() {
    }

    public static Point rotate(Point point, double theta) {
        double x = point.x() * Math.cos(theta) - point.y() * Math.sin(theta);
        double y = point.x() * Math.sin(theta) + point.y() * Math.cos(theta);

        return new Point(x, y);
    }
}

package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;

public class Sphere implements Transformation {
    @Override
    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        double radiusSquare = x * x + y * y;
        return new Point(x / radiusSquare, y / radiusSquare);
    }
}

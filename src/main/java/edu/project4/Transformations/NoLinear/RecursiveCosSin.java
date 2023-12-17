package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RecursiveCosSin implements Transformation {
    @Override
    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        double newX = sin(x * cos(y * sin(x)));
        double newY = cos(y * sin(x * cos(y)));

        return new Point(y - Math.pow(newX, 1 / newY), x - Math.pow(newY, 1 / newX));
    }
}

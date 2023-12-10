package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;
import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;

public class Polar implements Transformation {
    @Override
    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        double phi = atan(y / x);
        double radius = sqrt(x * x + y * y);
        return new Point(phi / PI, radius - 1);
    }
}

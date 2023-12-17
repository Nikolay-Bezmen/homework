package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CosSinusoid implements Transformation {
    @Override
    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        return new Point(x * cos(x + y), y * sin(x + y));
    }
}

package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;
import static java.lang.Math.sin;

public class Sinusoidal implements Transformation {
    @Override
    public Point transform(Point point) {
        return new Point(sin(point.x()), sin(point.y()));
    }
}

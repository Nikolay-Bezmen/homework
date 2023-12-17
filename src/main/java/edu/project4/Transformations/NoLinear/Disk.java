package edu.project4.Transformations.NoLinear;

import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Transformation;
import static edu.project4.Transformations.TransformUtils.getPhi;
import static edu.project4.Transformations.TransformUtils.getRadius;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Disk implements Transformation {
    @Override
    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        double phi = getPhi(x, y);
        double radius = getRadius(x, y);
        return new Point(
            (1.0 / PI) * phi * sin(PI * radius),
            (1.0 / PI) * phi * cos(PI * radius)
        );
    }
}

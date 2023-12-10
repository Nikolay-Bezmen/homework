package edu.project4.Transformations;

import static java.lang.Math.atan;
import static java.lang.Math.sqrt;

public class TransformUtils {
    private TransformUtils() {

    }

    public static double getRadius(double x, double y) {
        return sqrt(x * x + y * y);
    }

    public static double getPhi(double x, double y) {
        return atan(y / x);
    }
}

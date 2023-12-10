package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Point;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Affine implements Transformation {
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private final int red = random.nextInt(256);
    private final int green = random.nextInt(256);
    private final int blue = random.nextInt(256);

    public Affine() {
        c = random.nextDouble(-1.5, 1.5);
        f = random.nextDouble(-1.5, 1.5);

        do {
            generateAD();
            while (!isCorrectTransformAD()) {
                generateAD();
            }

            generateBE();
            while (!isCorrectTransformBE()) {
                generateBE();
            }
        } while (!isCorrectTransformTotal());

    }

    private boolean isCorrectTransformAD() {
        return (a * a + d * d) < 1;
    }

    private boolean isCorrectTransformBE() {
        return (b * b + e * e) < 1;
    }

    private boolean isCorrectTransformTotal() {
        return (a * a + b * b + d * d + e * e) < (1 + (a * e - d * b) * (a * e - d * b));
    }

    private void generateAD() {
        a = random.nextDouble();
        d = random.nextDouble();
    }

    private void generateBE() {
        b = random.nextDouble();
        e = random.nextDouble();
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }

    public Point transform(Point point) {
        double x = point.x();
        double y = point.y();

        double transformX = x * a + y * b + c;
        double transformY = x * d + y * e + f;

        return new Point(transformX, transformY);
    }
}

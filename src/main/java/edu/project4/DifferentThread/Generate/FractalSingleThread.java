package edu.project4.DifferentThread.Generate;

import edu.project4.ObjectOfImage.FractalHouse;
import edu.project4.ObjectOfImage.Pixel;
import edu.project4.ObjectOfImage.Point;
import edu.project4.Transformations.Affine;
import edu.project4.Transformations.RandomTransformation;
import edu.project4.Transformations.SymmetryRotatePoint;
import edu.project4.Transformations.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FractalSingleThread extends FractalGenerate {
    private final Pixel[][] pixels = new Pixel[IMAGE_WIDTH][IMAGE_HEIGHT];
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final List<Affine> affineTransform = new ArrayList<>();
    private final int countAffineTransformation;
    private final RandomTransformation randomTransform;

    public FractalSingleThread(FractalHouse house, int symmetry, List<Transformation> transformationList) {
        super(symmetry, house);
        randomTransform = new RandomTransformation(transformationList);

        for (int i = 0; i < house.affineCountTransform(); ++i) {
            affineTransform.add(new Affine());
        }
        for (int i = 0; i < pixels.length; ++i) {
            for (int j = 0; j < pixels[0].length; ++j) {
                pixels[i][j] = new Pixel();
            }
        }

        countAffineTransformation = affineTransform.size();
    }

    public Pixel[][] generate() {
        for (int i = 0; i < house.samplesCount(); ++i) {
            double x = random.nextDouble(MIN_VALID_X, MAX_VALID_X);
            double y = random.nextDouble(MIN_VALID_Y, MAX_VALID_Y);

            for (int step = prepareSteps; step < house.iterationsCount(); ++step) {
                Affine affine = affineTransform.get(random.nextInt(countAffineTransformation));

                if (step >= 0) {

                    double theta = 0;
                    double rotatePhi = Math.PI * 2 / symmetry;
                    Point point = randomTransform.transform(affine.transform(new Point(x, y)));
                    for (int count = 0; count < symmetry; theta += rotatePhi, count++) {

                        point = SymmetryRotatePoint.rotate(point, theta);
                        x = point.x();
                        y = point.y();
                        if (x >= MIN_VALID_X && x <= MAX_VALID_X && y >= MIN_VALID_Y && y <= MAX_VALID_Y) {

                            int nextX = ((int) (IMAGE_WIDTH * (MAX_VALID_X - x) / (MAX_VALID_X - MIN_VALID_X)));
                            int nextY = ((int) (IMAGE_HEIGHT * (MAX_VALID_Y - y) / (MAX_VALID_Y - MIN_VALID_Y)));

                            if (nextX < IMAGE_WIDTH && nextY < IMAGE_HEIGHT) {
                                Pixel pixel = pixels[nextX][nextY];
                                exchangePixel(pixel, affine);
                                pixel.incrementHitCount();
                            }
                        }
                    }
                }
            }
        }

        return pixels;
    }
}

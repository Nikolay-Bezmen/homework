package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Point;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTransformation implements Transformation {
    private final List<Transformation> transformations;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final int countTransformations;

    public RandomTransformation(List<Transformation> transformations) {
        this.transformations = transformations;
        countTransformations = transformations.size();
    }

    @Override
    public Point transform(Point point) {
        Transformation randomTransformation = transformations.get(random.nextInt(0, countTransformations));
        Point transformPoint = randomTransformation.transform(point);

        return transformPoint;
    }
}

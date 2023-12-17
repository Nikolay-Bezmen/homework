package edu.project4.Render;

import edu.project4.DifferentThread.Render.MultiThreadRender;
import edu.project4.ObjectOfImage.FractalHouse;
import edu.project4.ObjectOfImage.Pixel;
import edu.project4.Transformations.NoLinear.CosSinusoid;
import edu.project4.Transformations.NoLinear.Polar;
import edu.project4.Transformations.NoLinear.Sphere;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.ExecutionException;
import static edu.project4.DifferentThread.Render.FractalRender.IMAGE_HEIGHT;
import static edu.project4.DifferentThread.Render.FractalRender.IMAGE_WIDTH;
import static edu.project4.ImageUtils.CountPixels.countNotBlackPixels;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiThreadRenderTest {
    @Test
    void test_that_multi_threading_render_fractal() throws ExecutionException, InterruptedException {
        int samplesCount = 10_000;
        int iterationsCount = 50;
        int affineCountTransform = 100;
        int symmetry = 5;
        MultiThreadRender multiThreadRender = new MultiThreadRender(
            new FractalHouse(samplesCount, iterationsCount, affineCountTransform), symmetry,
            List.of(new CosSinusoid(), new Sphere(), new Polar()));


        Pixel[][] pixels = multiThreadRender.render("not save");

        int countNotBlackPixels = countNotBlackPixels(pixels);

        assertThat(countNotBlackPixels).isGreaterThan(0);
        assertThat(countNotBlackPixels).isLessThan(IMAGE_HEIGHT * IMAGE_WIDTH);
    }
}

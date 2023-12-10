package edu.project4.ImageUtils;

import edu.project4.ObjectOfImage.Pixel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static edu.project4.DifferentThread.Render.FractalRender.IMAGE_HEIGHT;
import static edu.project4.DifferentThread.Render.FractalRender.IMAGE_WIDTH;

@SuppressWarnings("MagicNumber")
public class MultiThreadWritePixels {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    private MultiThreadWritePixels() {
    }

    public static BufferedImage writePixels(BufferedImage image, Pixel[][] pixels)
        throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < IMAGE_WIDTH; ++i) {
            final int x = i;
            futures.add(executor.submit(() -> {
                for (int j = 0; j < IMAGE_HEIGHT; ++j) {
                    int r = pixels[x][j].r();
                    int g = pixels[x][j].g();
                    int b = pixels[x][j].b();
                    image.setRGB(x, j, r << 16 | g << 8 | b);
                }
                return null;
            }));
        }

        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();

        return image;
    }
}

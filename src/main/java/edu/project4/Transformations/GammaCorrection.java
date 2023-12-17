package edu.project4.Transformations;

import edu.project4.ObjectOfImage.Pixel;

@SuppressWarnings("MagicNumber")
public class GammaCorrection {
    private static final double GAMMA = 3;

    private GammaCorrection() {

    }

    public static Pixel[][] makeGammaCorrection(Pixel[][] pixels, int edge) {
        int width = pixels.length;
        int height = pixels[0].length;

        double max = 0;
        for (Pixel[] pixel : pixels) {
            for (int y = 0; y < height; ++y) {
                double normal = pixel[y].normal();
                if (normal > max) {
                    max = normal;
                }
            }
        }

        for (int x = 0; x + edge < width; x += 5) {
            for (int y = 0; y + edge < height; y += 5) {
                localRectCorrection(x, x + edge, y, y + edge, pixels);
            }
        }

        return pixels;
    }

    public static Pixel[][] defaultCorrection(Pixel[][] pixels) {
        double max = 0;
        for (Pixel[] value : pixels) {
            for (int y = 0; y < pixels[0].length; y++) {
                double normal = value[y].normal();
                if (normal > max) {
                    max = normal;
                }
            }
        }

        for (Pixel[] value : pixels) {
            for (int y = 0; y < pixels[0].length; y++) {
                Pixel pixel = value[y];
                double normal = pixel.normal();
                normal /= max;
                pixel.setR((int) (pixel.r() * Math.pow(normal, (1.0 / GAMMA))));
                pixel.setG((int) (pixel.g() * Math.pow(normal, (1.0 / GAMMA))));
                pixel.setB((int) (pixel.b() * Math.pow(normal, (1.0 / GAMMA))));
            }
        }

        return pixels;
    }

    private static void localRectCorrection(int minX, int maxX, int minY, int maxY, Pixel[][] pixels) {

        double max = 0;
        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                double normal = pixels[x][y].normal();
                if (normal > max) {
                    max = normal;
                }
            }
        }

        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                Pixel pixel = pixels[x][y];
                double normal = pixel.normal();
                normal /= max;
                pixel.setR((int) (pixel.r() * Math.pow(normal, (1.0 / GAMMA))));
                pixel.setG((int) (pixel.g() * Math.pow(normal, (1.0 / GAMMA))));
                pixel.setB((int) (pixel.b() * Math.pow(normal, (1.0 / GAMMA))));
            }
        }

    }

}

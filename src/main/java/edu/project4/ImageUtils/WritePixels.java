package edu.project4.ImageUtils;

import edu.project4.ObjectOfImage.Pixel;
import java.awt.image.BufferedImage;
import static edu.project4.DifferentThread.Render.SingleThreadRender.IMAGE_HEIGHT;
import static edu.project4.DifferentThread.Render.SingleThreadRender.IMAGE_WIDTH;

@SuppressWarnings("MagicNumber")
public class WritePixels {
    private WritePixels() {
    }

    public static BufferedImage writePixels(BufferedImage image, Pixel[][] pixels) {
        for (int i = 0; i < IMAGE_WIDTH; ++i) {
            for (int j = 0; j < IMAGE_HEIGHT; ++j) {
                int r = pixels[i][j].r();
                int g = pixels[i][j].g();
                int b = pixels[i][j].b();
                image.setRGB(i, j, r << 16 | g << 8 | b);
            }
        }

        return image;
    }
}

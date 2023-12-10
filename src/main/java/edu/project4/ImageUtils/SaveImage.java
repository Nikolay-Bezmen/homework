package edu.project4.ImageUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SaveImage {
    private SaveImage() {

    }

    public static void saveToFile(BufferedImage image, String path) {
        File file = new File(path);

        try {
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

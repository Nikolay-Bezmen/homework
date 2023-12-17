package edu.project4.ImageUtils;

import edu.project4.ObjectOfImage.Pixel;

public class CountPixels {
    private CountPixels() {

    }

    public static int countNotBlackPixels(Pixel[][] pixels) {
        int countNotBlack = 0;
        for (int i = 0; i < pixels.length; ++i) {
            for (int j = 0; j < pixels[0].length; ++j) {
                if (pixels[i][j].r() + pixels[i][j].b() + pixels[i][j].g() == 0) {
                    ++countNotBlack;
                }
            }
        }

        return countNotBlack;
    }
}

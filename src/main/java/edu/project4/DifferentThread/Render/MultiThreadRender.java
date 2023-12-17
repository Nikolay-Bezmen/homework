package edu.project4.DifferentThread.Render;

import edu.project4.DifferentThread.Generate.FractalMultiThread;
import edu.project4.ImageUtils.MultiThreadWritePixels;
import edu.project4.ImageUtils.SaveImage;
import edu.project4.ObjectOfImage.FractalHouse;
import edu.project4.ObjectOfImage.Pixel;
import edu.project4.Transformations.GammaCorrection;
import edu.project4.Transformations.Transformation;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MultiThreadRender extends FractalRender {
    private final List<Transformation> transformationList;

    public MultiThreadRender(FractalHouse house, int symmetry, List<Transformation> transformationList) {
        super(symmetry, house);
        this.transformationList = transformationList;
    }

    public Pixel[][] render(String path) throws ExecutionException, InterruptedException {
        FractalMultiThread fractalMultiThread = new FractalMultiThread(house, symmetry, transformationList);
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

        var pixels = fractalMultiThread.generate();

        GammaCorrection.defaultCorrection(pixels);
        MultiThreadWritePixels.writePixels(image, pixels);

        if (!path.equals("not save")) {
            SaveImage.saveToFile(image, path + "Gamma.jpg");
        }

        return pixels;
    }
}

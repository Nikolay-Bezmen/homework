package edu.project4.DifferentThread.Render;

import edu.project4.DifferentThread.Generate.FractalSingleThread;
import edu.project4.ImageUtils.SaveImage;
import edu.project4.ImageUtils.WritePixels;
import edu.project4.ObjectOfImage.FractalHouse;
import edu.project4.ObjectOfImage.Pixel;
import edu.project4.Transformations.GammaCorrection;
import edu.project4.Transformations.Transformation;
import java.awt.image.BufferedImage;
import java.util.List;

public class SingleThreadRender extends FractalRender {
    private final List<Transformation> transformationList;

    public SingleThreadRender(FractalHouse house, int symmetry, List<Transformation> transformationList) {
        super(symmetry, house);
        this.transformationList = transformationList;
    }

    public Pixel[][] render(String path) {
        FractalSingleThread fractalSingleThread = new FractalSingleThread(house, symmetry, transformationList);
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);

        var pixels = fractalSingleThread.generate();

        GammaCorrection.defaultCorrection(pixels);
        WritePixels.writePixels(image, pixels);
        if (!path.equals("not save")) {
            SaveImage.saveToFile(image, path + "Gamma.jpg");
        }

        return pixels;
    }

}

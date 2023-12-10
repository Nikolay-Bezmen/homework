package edu.project4.DifferentThread.Generate;

import edu.project4.DifferentThread.Render.FractalRender;
import edu.project4.ObjectOfImage.FractalHouse;
import edu.project4.ObjectOfImage.Pixel;
import edu.project4.Transformations.Affine;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public abstract class FractalGenerate extends FractalRender {
    protected static final double MIN_VALID_X = -1.777;
    protected static final double MAX_VALID_X = 1.777;
    protected static final double MIN_VALID_Y = -1;
    protected static final double MAX_VALID_Y = 1;
    protected final int prepareSteps = -20;
    protected final int localRandomRed;
    protected final int localRandomGreen;
    protected final int localRandomBlue;

    protected FractalGenerate(int symmetry, FractalHouse house) {
        super(symmetry, house);
        localRandomRed = ThreadLocalRandom.current().nextInt(256);
        localRandomGreen = ThreadLocalRandom.current().nextInt(256);
        localRandomBlue = ThreadLocalRandom.current().nextInt(256);
    }

    protected void exchangePixel(Pixel pixel, Affine affine) {
        if (pixel.hitCount() == 0) {
            pixel.setR(affine.red());
            pixel.setG(affine.green());
            pixel.setB(affine.blue());
        } else {
            pixel.setR((((pixel.r() + affine.red() + localRandomRed)) / 2) % 256);
            pixel.setG((((pixel.g() + affine.green() + localRandomGreen)) / 2) % 256);
            pixel.setB((((pixel.b() + affine.blue() + localRandomBlue)) / 2) % 256);
        }
    }
}

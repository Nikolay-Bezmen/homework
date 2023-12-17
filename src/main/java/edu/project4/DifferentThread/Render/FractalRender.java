package edu.project4.DifferentThread.Render;

import edu.project4.ObjectOfImage.FractalHouse;

public abstract class FractalRender {
    public static final int IMAGE_WIDTH = 1920;
    public static final int IMAGE_HEIGHT = 1080;
    protected final FractalHouse house;
    protected final int symmetry;

    public FractalRender(int symmetry, FractalHouse house) {
        this.symmetry = symmetry;
        this.house = house;
    }
}

package edu.project4.ObjectOfImage;

public class Pixel {
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int hitCount = 0;

    public Pixel() {
    }

    public Pixel(Pixel pixel) {
        this.r = pixel.r();
        this.g = pixel.g();
        this.b = pixel.b();
    }

    public int r() {
        return r;
    }

    public int g() {
        return g;
    }

    public int b() {
        return b;
    }

    public double normal() {
        return Math.log10(hitCount);
    }

    public int hitCount() {
        return hitCount;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void incrementHitCount() {
        ++hitCount;
    }

}

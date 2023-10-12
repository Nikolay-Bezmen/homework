package edu.hw2.Task2;

public class Rectangle implements Shape{
    int height;
    int width;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double area() {
        return this.height * this.width;
    }
}

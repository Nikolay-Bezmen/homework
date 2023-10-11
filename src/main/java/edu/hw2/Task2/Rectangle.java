package edu.hw2.Task2;

public class Rectangle extends Shape{
    public Rectangle(int width, int height) {
        super(width, height);
    }

    public void setWidth(int width) {
        super.setWidth(width);
    }

    public void setHeight(int height) {
        super.setHeight(height);
    }

    public double area() {
        return this.getHeight() * this.getWidth();
    }
}

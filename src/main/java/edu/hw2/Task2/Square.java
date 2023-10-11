package edu.hw2.Task2;

public class Square extends Shape {

    public Square(int side) {
        super(side, side);
    }

    @Override public void setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);
    }

    @Override public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

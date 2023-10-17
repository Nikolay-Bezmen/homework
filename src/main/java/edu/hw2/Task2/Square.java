package edu.hw2.Task2;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    public Square setWidth(int width) {
        return new Square(width);
    }

    public Square setHeight(int height) {
        return new Square(height);
    }

    public Square setSide(int side) {
        return new Square(side);
    }
}

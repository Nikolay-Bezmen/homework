package edu.hw2.Task2;

public class Square implements Shape {
    int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }
}

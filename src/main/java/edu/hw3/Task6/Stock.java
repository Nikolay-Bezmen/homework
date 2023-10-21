package edu.hw3.Task6;

public class Stock {
    private String companyName;
    private int cost;

    public Stock(String companyName, int cost) {
        this.companyName = companyName;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

}

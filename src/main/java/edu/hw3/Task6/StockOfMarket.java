package edu.hw3.Task6;

import java.util.PriorityQueue;

public class StockOfMarket implements StockMarket {
    PriorityQueue<Stock> stockExchange = new PriorityQueue<>((a, b) -> b.getCost() - a.getCost());

    @Override
    public void add(Stock stock) {
        stockExchange.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockExchange.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockExchange.peek();
    }

    public boolean containsStock(Stock stock) {
        return stockExchange.contains(stock);
    }
}

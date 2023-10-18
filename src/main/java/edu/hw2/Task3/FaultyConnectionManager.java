package edu.hw2.Task3;

public class FaultyConnectionManager implements ConnectionManager {
    private int howOftenSucces;

    public FaultyConnectionManager(int howOftenSucces) {
        this.howOftenSucces = howOftenSucces;
        FaultyConnection.newConnect();
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(howOftenSucces);
    }
}

package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private int countConnect;
    private int howOftenSucces;

    public DefaultConnectionManager(int howOftenSucces) {
        this.howOftenSucces = howOftenSucces;
        countConnect = 0;
        FaultyConnection.newConnect();
    }

    @Override
    public Connection getConnection() {
        if (++countConnect % 2 != 0) {
            return new FaultyConnection(howOftenSucces);
        }
        return new StableConnection();
    }
}

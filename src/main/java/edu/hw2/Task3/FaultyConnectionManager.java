package edu.hw2.Task3;

public class FaultyConnectionManager implements ConnectionManager {
    private int HOW_OFTEN_SUCCES;

    public FaultyConnectionManager(int how_often_succes) {
        HOW_OFTEN_SUCCES = how_often_succes;
        FaultyConnection.newConnect();
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(HOW_OFTEN_SUCCES);
    }
}

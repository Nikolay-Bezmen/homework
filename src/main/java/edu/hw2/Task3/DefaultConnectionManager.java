package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private static int countConnect = 0;
    private final int HOW_OFTEN_SUCCESS;

    public DefaultConnectionManager(int how_often_succes) {
        HOW_OFTEN_SUCCESS = how_often_succes;
        countConnect = 0;
        FaultyConnection.newConnect();
    }

    @Override
    public Connection getConnection() {
        if (++countConnect % 2 != 0) {
            return new FaultyConnection(HOW_OFTEN_SUCCESS);
        }
        return new StableConnection();
    }
}

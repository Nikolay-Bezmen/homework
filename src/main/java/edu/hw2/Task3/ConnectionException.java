package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String overFaultyConnect) {
        super(overFaultyConnect);
    }

    public ConnectionException() {
    }

}

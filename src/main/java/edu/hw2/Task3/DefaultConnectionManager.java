package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        if(new Random().nextInt() % 3 == 1){
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}

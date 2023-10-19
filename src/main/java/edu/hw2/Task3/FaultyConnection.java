package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private static int countAttempts = 0;
    public int howOftenSucces;
    public final static String CLOSE_IS_SUCCESS = "соединение закрылось успешно";

    FaultyConnection(int howOftenSucces) {
        this.howOftenSucces = howOftenSucces;
    }

    public static void newConnect() {
        countAttempts = 0;
    }

    @Override
    public void execute(String command) throws ConnectionException {
        if (++countAttempts % howOftenSucces != 0) {
            throw new ConnectionException();
        }
        LOGGER.info("команда " + command + " выполнилась успешно через проблемное соединение");
    }

    @Override
    public void close() {
        LOGGER.info(CLOSE_IS_SUCCESS);
    }
}

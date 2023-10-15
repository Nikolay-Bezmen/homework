package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private static int countAttempts = 0;
    public int HOW_OFTEN_SUCCESS;
    public final static String CONNECT_WORKED_SUCCESSFULLY = "произошло успешное соединение";
    public final static String CLOSE_IS_SUCCESS = "соединение закрылось успешно";

    FaultyConnection(int how_often_succes) {
        HOW_OFTEN_SUCCESS = how_often_succes;
    }

    public static void newConnect() {
        countAttempts = 0;
    }

    @Override
    public void execute(String command) throws ConnectionException {
        if (++countAttempts % HOW_OFTEN_SUCCESS != 0) {
            throw new ConnectionException();
        }
        LOGGER.info(CONNECT_WORKED_SUCCESSFULLY);
        LOGGER.info("команда " + command + " выполнилась успешно");
    }

    @Override
    public void close() {
        LOGGER.info(CLOSE_IS_SUCCESS);
    }
}

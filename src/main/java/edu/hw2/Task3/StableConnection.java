package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String CONNECT_WORKED_SUCCESSFULLY = "произошло успешное соединение";
    private final static String CLOSE_IS_SUCCES = "соединение закрылось успешно";

    StableConnection() {
        FaultyConnection.newConnect();
    }

    @Override
    public void execute(String command) {
        LOGGER.info(CONNECT_WORKED_SUCCESSFULLY);
        LOGGER.info("команда " + command + " выполнилась успешно");
    }

    @Override
    public void close() {
        LOGGER.info(CLOSE_IS_SUCCES);
    }
}

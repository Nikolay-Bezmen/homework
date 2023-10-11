package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection{
    private static final String OVER_FAULTY_CONNECT = "ошибка, плохое соединение";
    private final static String CONNECT_WORKED_SUCCESSFULLY = "произошло успешное соединение";
    private final static String CLOSE_IS_SUCCES = "соединение закрылось успешно";
    @Override
    public void execute(String command) throws Exception {
        if(new Random().nextInt() % 4 == 1){
            throw new ConnectionException(OVER_FAULTY_CONNECT);
        }
        System.out.println(CONNECT_WORKED_SUCCESSFULLY);
        System.out.println("команда " + command + " выполнилась успешно");
        close();
    }

    @Override
    public void close() throws Exception {
        System.out.println(CLOSE_IS_SUCCES);
    }
}

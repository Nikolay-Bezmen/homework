package edu.hw2.Task3;

public class StableConnection implements Connection{
    private final static String CONNECT_WORKED_SUCCESSFULLY = "произошло успешное соединение";
    private final static String CLOSE_IS_SUCCES = "соединение закрылось успешно";
    @Override
    public void execute(String command) throws Exception {
        System.out.println(CONNECT_WORKED_SUCCESSFULLY);
        System.out.println("команда " + command + " выполнилась успешно");
        close();
    }

    @Override
    public void close() throws Exception {
        System.out.println(CLOSE_IS_SUCCES);
    }
}

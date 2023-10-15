package edu.hw2.Task3;

public class FaultyConnection implements Connection{
    private static int countAttempts = 0;
    public int HOW_OFTEN_SUCCESS;
    public final static String CONNECT_WORKED_SUCCESSFULLY = "произошло успешное соединение";
    public final static String CLOSE_IS_SUCCESS = "соединение закрылось успешно";
    FaultyConnection(int how_often_succes){
        HOW_OFTEN_SUCCESS = how_often_succes;
    }

    public static void newConnect(){
        countAttempts = 0;
    }
    @Override
    public void execute(String command) throws ConnectionException {
        if(++countAttempts % HOW_OFTEN_SUCCESS != 0){
            throw new ConnectionException();
        }
        System.out.println(CONNECT_WORKED_SUCCESSFULLY);
        System.out.println("команда " + command + " выполнилась успешно");
    }

    @Override
    public void close() {
        System.out.println(CLOSE_IS_SUCCESS);
    }
}

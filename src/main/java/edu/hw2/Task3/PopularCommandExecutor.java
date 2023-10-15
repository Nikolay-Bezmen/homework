package edu.hw2.Task3;


public class PopularCommandExecutor {
    public final static String CONNECT_IS_FAULTY = "Соединения не произошло!";
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        String COMMAND = "apt update && apt upgrade -y";
        tryExecute(COMMAND);
    }

    private void tryExecute(String command) throws ConnectionException{
        int countTryies = 0;
        while(maxAttempts != countTryies){
            ++countTryies;
            Connection currentConnection = manager.getConnection();
            try{
                currentConnection.execute(command);
                return;
            }catch (ConnectionException e){
                System.out.println("Соединения не произошло; попыток осталось " +
                    (maxAttempts - countTryies));
            }finally {
                try {
                    currentConnection.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        throw new ConnectionException(CONNECT_IS_FAULTY);
    }
}

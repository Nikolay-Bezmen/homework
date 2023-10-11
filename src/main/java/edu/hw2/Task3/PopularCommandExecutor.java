package edu.hw2.Task3;


public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws ConnectionException{
        int countTryies = 0;
        while(maxAttempts != countTryies){
            ++countTryies;
            Connection currentConnection = manager.getConnection();
            try{
                currentConnection.execute(command);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

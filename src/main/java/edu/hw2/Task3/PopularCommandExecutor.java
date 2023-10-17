package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();
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

    private void tryExecute(String command) throws ConnectionException {
        int countTryies = 0;
        while (maxAttempts != countTryies) {
            ++countTryies;
            try (Connection currentConnection = manager.getConnection()) {
                currentConnection.execute(command);
                return;
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }
        }

        throw new ConnectionException(CONNECT_IS_FAULTY);
    }
}

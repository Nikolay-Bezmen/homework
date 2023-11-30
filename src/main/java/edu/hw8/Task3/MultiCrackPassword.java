package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings("MagicNumber")
public class MultiCrackPassword {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    static final int BASE = 36;
    private static final int COUNT_THREAD = Runtime.getRuntime().availableProcessors();
    private static final int MAX_PASSWORD_LENGTH = 4;
    private static final ConcurrentMap<String, String> MAP = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, String> CRACK_MAP = new ConcurrentHashMap<>();

    private MultiCrackPassword() {
    }

    public static void crackPassword(int lengthOfPassword) throws InterruptedException {
        ExecutorService executer = Executors.newFixedThreadPool(COUNT_THREAD);

        for (int i = 0; i < 36; ++i) {
            int finalI = i;
            executer.submit(() -> {
                try {
                    generatePassword(lengthOfPassword, finalI);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executer.shutdown();
        executer.awaitTermination(3, TimeUnit.MINUTES);
    }

    static void generatePassword(int passwordLength, int currSymbol) throws NoSuchAlgorithmException {
        int[] password = new int[passwordLength];
        password[0] = currSymbol;
        for (int i = 1; i < passwordLength; ++i) {
            password[i] = 0;
        }
        long countSimulation = (long) Math.pow(36, passwordLength - 1);

        for (long i = 0; i < countSimulation; ++i) {
            StringBuilder sb = new StringBuilder();

            for (int k : password) {
                sb.append(ALPHABET.charAt(k));
            }
            String currPassword = sb.toString();

            String hash = calculateHash(currPassword);

            if (MAP.containsKey(hash)) {
                CRACK_MAP.put(MAP.get(hash), currPassword);
            }
            if (!nextPermutation(password)) {
                return;
            }

        }
    }

    static boolean nextPermutation(int[] password) {
        int currPosition = password.length - 1;

        while (currPosition >= 0 && password[currPosition] == BASE - 1) {
            password[currPosition] = 0;
            --currPosition;
        }

        if (currPosition < 0) {
            return false;
        }

        ++password[currPosition];

        return true;
    }

    static String calculateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public static Map<String, String> startCracking(Map<String, String> hashToUser, int lengthOfPassword)
        throws InterruptedException {
        for (String hashKey : hashToUser.keySet()) {
            MAP.put(hashKey, hashToUser.get(hashKey));
        }

        if (lengthOfPassword >= 1 && lengthOfPassword <= MAX_PASSWORD_LENGTH) {
            crackPassword(lengthOfPassword);
        } else {
            for (int i = 1; i <= MAX_PASSWORD_LENGTH; ++i) {
                crackPassword(i);
            }
        }

        for (String user : CRACK_MAP.keySet()) {
            LOGGER.info(user + " : " + CRACK_MAP.get(user));
        }

        return CRACK_MAP;
    }
}

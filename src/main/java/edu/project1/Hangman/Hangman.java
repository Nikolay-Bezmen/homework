package edu.project1.Hangman;

import edu.project1.GameSession.GameSession;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MemberName", "MagicNumber"})
public class Hangman {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Scanner scanner;
    GameSession gameSession;

    private final String EXIT = "exit";

    public Hangman() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        boolean exit = false;
        LOGGER.info("if you wanna finish game then input exit");
        while (!exit) {
            gameSession = new GameSession();
            try {
                while (!gameSession.wordIsGuessed() && gameSession.countMistakesIsValid()) {
                    LOGGER.info("Guess a letter:");
                    String line = scanner.nextLine();
                    if (line.equals(EXIT)) {
                        exit = true;
                        break;
                    }
                    if (!isIncorrectLine(line)) {
                        LOGGER.info("incorrect input data, try again");
                        continue;
                    }
                    if (gameSession.getChars().contains(line.charAt(0))) {
                        LOGGER.info("Hit!");
                        gameSession.addGuessedLetter(line.charAt(0));
                    } else {
                        LOGGER.info("Missed, mistake " + gameSession.incremAmountMistakes()
                            + " out of " + gameSession.getCountAvailableMistakes());
                    }
                    LOGGER.info("The word: " + gameSession.showGuessedLetterInWord());
                }

                LOGGER.info(gameSession.wordIsGuessed() ? "YOU WON" : "YOU LOST");
            } catch (Exception e) {
                LOGGER.info(e.getStackTrace());
            }
            LOGGER.info("you wanna new game?");
            if (scanner.nextLine().equals(EXIT)) {
                exit = true;
            }
        }
    }

    public boolean isIncorrectLine(String line) {
        return line.length() == 1 && line.charAt(0) <= 'z'
            && line.charAt(0) >= 'a' && !gameSession.getGuessedChars().contains(line.charAt(0));
    }

}

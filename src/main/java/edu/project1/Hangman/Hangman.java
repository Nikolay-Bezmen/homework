package edu.project1.Hangman;

import edu.project1.Utils.ListUtils;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class Hangman {
    private final static Logger LOGGER = LogManager.getLogger();
    protected static List<String> setWords = List.of("banana", "chocolate", "coffee", "apple", "horse");
    private final String guessWord;
    private final Set<Character> guessChars;
    private boolean[] chars;
    private int countGuessedChars;
    private static final int COUNT_AVAILABLE_MISTAKE = 5;
    private int numberOfMistakesMade;
    private final Scanner scanner;

    public Hangman() {
        this.scanner = new Scanner(System.in);
        this.guessWord = ListUtils.getRandomItem(setWords);
        this.guessChars = this.numberOfDifferenceLetters(guessWord);
        this.chars = new boolean[26];
        this.countGuessedChars = 0;
        this.numberOfMistakesMade = 0;
    }

    public void run() {
        try {
            while (!wordIsGuessed() && countMistakesIsValid()) {
                LOGGER.info("Guess a letter:");
                char nextGuessLetter = scanner.nextLine().charAt(0);
                if (guessChars.contains(nextGuessLetter)) {
                    LOGGER.info("Hit!");
                    ++countGuessedChars;
                    chars[nextGuessLetter - 'a'] = true;
                } else {
                    LOGGER.info("Missed, mistake " + ++numberOfMistakesMade + " out of " + COUNT_AVAILABLE_MISTAKE);
                }
                LOGGER.info("The word: " + showGuessedLetterInWord());
            }

            LOGGER.info(wordIsGuessed() ? "YOU WON" : "YOU LOST");
        } catch (Exception e) {
            LOGGER.info(e.getStackTrace());
        }
    }

    protected String showGuessedLetterInWord() {
        StringBuilder word = new StringBuilder();
        for (char ch : guessWord.toCharArray()) {
            if (chars[ch - 'a']) {
                word.append(ch);
            } else {
                word.append("*");
            }
        }

        return word.toString();
    }

    protected boolean wordIsGuessed() {
        return countGuessedChars == guessChars.size();
    }

    protected boolean countMistakesIsValid() {
        return numberOfMistakesMade < COUNT_AVAILABLE_MISTAKE;
    }

    protected Set<Character> numberOfDifferenceLetters(String word) {
        return word.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

}

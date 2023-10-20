package edu.project1.GameSession;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("MemberName")
public class GameSession {
    private final String word;
    private final int COUNT_AVAILABLE_MISTAKE = 5;
    private int amountMistakes = 0;
    private final Set<Character> chars;
    private final Set<Character> guessedChars = new HashSet<>();

    public GameSession() {
        this.word = Dictionary.getRandomWord();
        this.chars = word.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    public String getWord() {
        return word;
    }

    public int getCountAvailableMistakes() {
        return COUNT_AVAILABLE_MISTAKE;
    }

    public int getAmountMistakes() {
        return amountMistakes;
    }

    public Set<Character> getGuessedChars() {
        return guessedChars;
    }

    public Set<Character> getChars() {
        return chars;
    }

    public int incremAmountMistakes() {
        return ++amountMistakes;
    }

    public void addGuessedLetter(char ch) {
        guessedChars.add(ch);
    }

    public String showGuessedLetterInWord() {
        StringBuilder currWord = new StringBuilder();
        for (char ch : getWord().toCharArray()) {
            if (getGuessedChars().contains(ch)) {
                currWord.append(ch);
            } else {
                currWord.append('*');
            }
        }

        return currWord.toString();
    }

    public boolean wordIsGuessed() {
        return getChars().size() == getGuessedChars().size();
    }

    public boolean countMistakesIsValid() {
        return getCountAvailableMistakes() > getAmountMistakes();
    }
}

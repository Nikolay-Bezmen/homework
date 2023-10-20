package edu.project1.GameSession;

import java.util.List;

public class Dictionary {
    private static final List<String> setWords = List.of("banana", "chocolate", "coffee", "apple", "horse");

    public static String getRandomWord() {
        int indexOfRandomAccess = (int) System.currentTimeMillis() % (setWords.size());
        return setWords.get(indexOfRandomAccess);
    }

    public static List<String> getSetWords() {
        return setWords;
    }

    private Dictionary() {
    }
}

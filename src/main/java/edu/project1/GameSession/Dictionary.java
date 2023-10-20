package edu.project1.GameSession;

import java.util.List;

public class Dictionary {
    private static final List<String> SET_WORD = List.of("banana", "chocolate", "coffee", "apple", "horse");

    public static String getRandomWord() {
        int indexOfRandomAccess = (int) System.currentTimeMillis() % (SET_WORD.size());
        return SET_WORD.get(indexOfRandomAccess);
    }

    public static List<String> getSetWords() {
        return SET_WORD;
    }

    private Dictionary() {
    }
}

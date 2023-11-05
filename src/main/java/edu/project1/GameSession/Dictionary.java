package edu.project1.GameSession;

import java.util.List;
import java.util.Random;

public class Dictionary {
    private static final List<String> SET_WORD = List.of("banana", "chocolate", "coffee", "apple", "horse");
    private final static Random RANDOM = new Random();

    public static String getRandomWord() {
        int indexOfRandomAccess = RANDOM.nextInt(SET_WORD.size());
        return SET_WORD.get(indexOfRandomAccess);
    }

    public static List<String> getSetWords() {
        return SET_WORD;
    }

    private Dictionary() {
    }
}

package edu.project1;

import edu.project1.Hangman.Hangman;

@SuppressWarnings("UncommentedMain")
public class App {

    public static void main(java.lang.String[] args) {
        Hangman hangman = new Hangman();
        hangman.run();
    }

    private App() {
    }
}

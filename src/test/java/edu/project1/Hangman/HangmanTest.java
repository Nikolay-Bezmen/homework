package edu.project1.Hangman;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HangmanTest {
    @Test
    void word_is_guessed() {
        Hangman hangman = new Hangman();

        boolean result = hangman.wordIsGuessed();

        assertThat(result).isEqualTo(false);
    }

    @Test
    void test_word_to_set() {
        String word = "appleblack";
        Set<Character> set = Set.of('a', 'p', 'l', 'e', 'b', 'k', 'c');

        Set<Character> resultSet = new Hangman().numberOfDifferenceLetters(word);

        assertThat(resultSet).isEqualTo(set);
    }

    @Test
    void test_show_guess_letters() {
        String result = new Hangman().showGuessedLetterInWord();

        assertThat(result.chars().filter(c -> c == '*').count()).isEqualTo(result.length());
    }

    @Test
    void test_count_of_mistake() {
        boolean result = new Hangman().countMistakesIsValid();

        assertThat(result).isTrue();
    }
}

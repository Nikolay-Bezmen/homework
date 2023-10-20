package edu.project1.GameSessionTest;

import edu.project1.GameSession.Dictionary;
import edu.project1.GameSession.GameSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import java.util.HashSet;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class GameSessionTest {
    GameSession gs;
    @BeforeEach
    void set_up(){
        gs = new GameSession();
    }
    @Test
    void check_guessed_letter(){
        GameSession gameSession = Mockito.spy(gs);
        when(gameSession.getWord()).thenReturn(Dictionary.getRandomWord());
        when(gameSession.getGuessedChars()).thenReturn(new HashSet<>());

        String word = gameSession.showGuessedLetterInWord();
        int countStars = (int) word.chars().filter(ch -> ch == '*').count();

        assertThat(word.length()).isEqualTo(countStars);
    }


    @Test
    void check_not_guessed_letter(){
        GameSession gameSession = Mockito.spy(gs);
        when(gameSession.getWord()).thenReturn(Dictionary.getRandomWord());
        when(gameSession.getGuessedChars()).thenReturn(new HashSet<>());

        String word = gameSession.showGuessedLetterInWord();
        int countStars = (int) word.chars().filter(ch -> ch == '*').count();

        assertThat(word.length()).isEqualTo(countStars);
    }
    @Test
    void check_if_word_is_guessed(){
        for(char ch: gs.getWord().toCharArray()){
            gs.addGuessedLetter(ch);
        }

        assertThat(gs.wordIsGuessed()).isTrue();
    }

    @Test
    void check_if_word_is_guessed_not_valid(){
        for(char ch: gs.getWord().toCharArray()){
            gs.addGuessedLetter(ch);
        }
        gs.getGuessedChars().remove(gs.getWord().charAt(0));

        assertThat(gs.wordIsGuessed()).isFalse();
    }

    @ParameterizedTest
    @MethodSource("getCharacters")
    void check_add_guessed_letter(char ch){
        gs.addGuessedLetter(ch);

        boolean guessedCharsContainsCH = gs.getGuessedChars().contains(ch);

        assertThat(guessedCharsContainsCH).isTrue();
    }

    private static Stream<Arguments> getCharacters(){
        return Stream.of(
            Arguments.of('a'),
            Arguments.of('b'),
            Arguments.of('c'),
            Arguments.of('d')
        );
    }

    @ParameterizedTest
    @MethodSource("getCountOfMistakesMade")
    void check_count_mistakes_is_valid(int countMistakes){
        for(int i = 0; i < countMistakes; ++i){
            gs.incremAmountMistakes();
        }

        assertThat(gs.countMistakesIsValid()).isTrue();
    }

    private static Stream<Arguments> getCountOfMistakesMade(){
        return Stream.of(
            Arguments.of(0),
            Arguments.of(1),
            Arguments.of(2),
            Arguments.of(3),
            Arguments.of(4)
            );
    }
}

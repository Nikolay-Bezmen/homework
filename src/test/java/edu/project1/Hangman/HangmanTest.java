package edu.project1.Hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HangmanTest {
    Hangman hangman;
    @BeforeEach
    void set_up(){
        hangman = new Hangman();

    }
    @ParameterizedTest
    @MethodSource("getIncorrectLines")
    void check_incorrect_line(String line){
        boolean correct = hangman.isIncorrectLine(line);

        assertThat(correct).isFalse();
    }

    private static Stream<Arguments> getIncorrectLines(){
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("rqtqt"),
            Arguments.of("A")
        );
    }
}

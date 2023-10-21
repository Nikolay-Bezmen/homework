package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw3.Task2.INPUT_LINE_IS_NOT_VALID;
import static edu.hw3.Task2.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @ParameterizedTest
    @MethodSource("getStrings")
    void check_correct_results(String line, String[] clasters) {
        String[] result = clusterize(line);

        assertThat(result.length).isEqualTo(clasters.length);

        for (int i = 0; i < clasters.length; ++i) {
            assertThat(clasters[i]).isEqualTo(result[i]);
        }
    }

    private static Stream<Arguments> getStrings() {
        return Stream.of(
            Arguments.of("()()()", new String[] {"()", "()", "()"}),
            Arguments.of("((()))", new String[] {"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"})
        );
    }

    @ParameterizedTest
    @MethodSource("getIncorrectLines")
    void throws_if_input_date_is_not_correct(String line) {
        var except = assertThrows(
            IllegalArgumentException.class,
            () -> clusterize(line)
        );

        assertThat(except.getMessage()).isEqualTo(INPUT_LINE_IS_NOT_VALID);
    }

    private static Stream<Arguments> getIncorrectLines() {
        return Stream.of(
            Arguments.of("()()())"),
            Arguments.of("))))(((("),
            Arguments.of("((((()))"),
            Arguments.of("(()))("),
            Arguments.of("((((((())))()()((")
        );
    }
}

package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task6.isSubsequence;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @ParameterizedTest
    @MethodSource("getRealSubsequences")
    void check_if_S_is_subsequence_for_T(String S, String T) {
        boolean resultOfCheck = isSubsequence(S, T);

        assertThat(resultOfCheck).isTrue();
    }

    private static Stream<Arguments> getRealSubsequences() {
        return Stream.of(
            Arguments.of("abc", "ngiwonabc9u019"),
            Arguments.of("aBc", "ngiwonaBc9u019"),
            Arguments.of("  ", "iobw  ivoow"),
            Arguments.of("99k", "wiogwiin99kvoiw"),
            Arguments.of(" vn 89", "jvnwo vn 8913r8hc")
        );
    }

    @ParameterizedTest
    @MethodSource("getInvalidSubsequences")
    void check_if_S_is_not_subsequence_for_T(String S, String T) {
        boolean resultOfCheck = isSubsequence(S, T);

        assertThat(resultOfCheck).isFalse();
    }

    private static Stream<Arguments> getInvalidSubsequences() {
        return Stream.of(
            Arguments.of("abc", "ngiwonabababbc9u019"),
            Arguments.of("aBc", "ngiwonaBBc9u019"),
            Arguments.of("  ", "iobw ivoow"),
            Arguments.of("99k", "wiogwiin99voiw"),
            Arguments.of(" vn 89", "jvnwo n 8913r8hc")
        );
    }

}

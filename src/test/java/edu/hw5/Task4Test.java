package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task4.specialPassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @ParameterizedTest
    @MethodSource("getSpecialPasswords")
    void check_special_password(String password) {
        boolean resultOfCheck = specialPassword(password);

        assertThat(resultOfCheck).isTrue();
    }

    private static Stream<Arguments> getSpecialPasswords() {
        return Stream.of(
            Arguments.of("wkjefhie%"),
            Arguments.of("83y59823th^jfi3hg"),
            Arguments.of("$jkhegiq9ueh"),
            Arguments.of("mg7bf#ubfge"),
            Arguments.of("biw@nIo"),
            Arguments.of("bgiwu!8592hg"),
            Arguments.of("kjehfw&ur901fh"),
            Arguments.of("jiwbv*kjfoif87941"),
            Arguments.of("iwneoi|jnew89nKJ")
        );
    }

    @Test
    void check_just_usually_password() {
        String password = "12345NNKKjh8y29nksnv";

        boolean resultOfCheck = specialPassword(password);

        assertThat(resultOfCheck).isFalse();
    }
}

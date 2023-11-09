package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @ParameterizedTest
    @MethodSource("getCorrectFormatDate")
    void test_correct_format(String date, Optional<LocalDate> correctResult){
        Optional<LocalDate> resultOfWork = Task3.parseDate(date);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }

    private static Stream<Arguments> getCorrectFormatDate(){
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 1, 3))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 1, 3))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(2234)))
        );
    }

    @ParameterizedTest
    @MethodSource("getIncorrectFormatDate")
    void test_correct_format(String date){
        Optional<LocalDate> resultOfWork = Task3.parseDate(date);

        assertThat(resultOfWork).isEqualTo(Optional.empty());
    }

    private static Stream<Arguments> getIncorrectFormatDate(){
        return Stream.of(
            Arguments.of("2020-10- 10"),
            Arguments.of("2020-1/2"),
            Arguments.of("1/31976"),
            Arguments.of("1/3 /20"),
            Arguments.of("tomorow"),
            Arguments.of("Today"),
            Arguments.of("yester day"),
            Arguments.of("1 day ag"),
            Arguments.of("2234 Days ago"),
            Arguments.of("two Days ago")
        );
    }
}

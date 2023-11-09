package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw5.Task2.findAllFridayThirteenOnYear;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @ParameterizedTest
    @MethodSource("getLocalDates")
    void check_on_correct_dates_of_friday_thirteen(LocalDate date, LocalDate correctDates){
        LocalDate resultOfCalculate = findAllFridayThirteenOnYear(date);

        assertThat(resultOfCalculate).isEqualTo(correctDates);
    }

    private static Stream<Arguments> getLocalDates(){
        return Stream.of(
            Arguments.of(LocalDate.of(1999, 1, 17), LocalDate.of(1999, 8, 13)),
            Arguments.of(LocalDate.of(1973, 4, 13), LocalDate.of(1973, 4, 13)),
            Arguments.of(LocalDate.of(1924, 5, 2), LocalDate.of(1924, 6, 13)),
            Arguments.of(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 2, 13))
        );
    }

    @ParameterizedTest
    @MethodSource("getYears")
    void check_on_correct_dates_of_friday_thirteen(Integer year, List<LocalDate> correctDates){
        List<LocalDate> resultOfCalculate = findAllFridayThirteenOnYear(year);

        assertThat(resultOfCalculate).isEqualTo(correctDates);
    }

    private static Stream<Arguments> getYears(){
        return Stream.of(
            Arguments.of(1999, List.of(LocalDate.of(1999, 8, 13))),
            Arguments.of(1973, List.of(
                LocalDate.of(1973, 4, 13),
                LocalDate.of(1973, 7, 13)
            )),
            Arguments.of(1924, List.of(LocalDate.of(1924, 6, 13))),
            Arguments.of(2015, List.of(
                LocalDate.of(2015, 2, 13),
                LocalDate.of(2015, 3, 13),
                LocalDate.of(2015, 11, 13)
            ))
        );
    }
}

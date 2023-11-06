package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task1.INCORRECT_DATE;
import static edu.hw5.Task1.INCORRECT_FORMAT;
import static edu.hw5.Task1.averageTimeOfOneSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @ParameterizedTest
    @MethodSource("getSessionsTime")
    void check_correct_calculate_average_time_of_session(String[] sessions, String correctTime){
        String resultOfCalculate = averageTimeOfOneSession(sessions);

        assertThat(resultOfCalculate).isEqualTo(correctTime);
    }

    private static Stream<Arguments> getSessionsTime(){
        return Stream.of(
            Arguments.of(new String[]{
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            }, "3ч 40м"),
            Arguments.of(new String[]{
                "2023-07-11, 17:18 - 2023-07-11, 23:34",
                "2023-06-10, 19:03 - 2023-06-10, 22:19",
                "2023-01-13, 21:13 - 2023-01-14, 07:23",
                "2023-02-11, 22:19 - 2023-02-12, 00:15"
            }, "5ч 24м")
        );
    }

    @ParameterizedTest
    @MethodSource("getIncorrectDate")
    void throw_if_incorrect_data(String[] sessions){
        var except = assertThrows(IllegalArgumentException.class, () -> averageTimeOfOneSession(sessions));

        assertThat(except.getMessage()).isEqualTo(INCORRECT_DATE);
    }

    private static Stream<Arguments> getIncorrectDate(){
        return Stream.of(
            Arguments.of((Object) new String[]{"2022-03-32, 20:20 - 2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-13-12, 20:20 - 2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 24:20 - 2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:60 - 2022-03-12, 23:50"})

        );
    }

    @ParameterizedTest
    @MethodSource("getIncorrectDateFormat")
    void throw_if_incorrect_type_of_data(String[] sessions){
        var except = assertThrows(IllegalArgumentException.class, () -> averageTimeOfOneSession(sessions));

        assertThat(except.getMessage()).isEqualTo(INCORRECT_FORMAT);
    }

    private static Stream<Arguments> getIncorrectDateFormat(){
        return Stream.of(
            Arguments.of((Object) new String[]{"2022-03-12 20:20 - 2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20 -@ 2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20  2022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20 - 022-03-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20 - 2022-0312, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20 - 202203-12, 23:50"}),
            Arguments.of((Object) new String[]{"2022-03-12, 20:20 - 2022-03-12 23:50"})
        );
    }
}

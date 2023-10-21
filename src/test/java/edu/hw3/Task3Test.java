package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Map;
import java.util.stream.Stream;
import static edu.hw3.Task3.freqDict;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @ParameterizedTest
    @MethodSource("getObjects")
    void check_correct_work(Map<Object, Integer> frequency, Object[] objects) {
        assertThat(frequency).isEqualTo(freqDict(objects));
    }

    private static Stream<Arguments> getObjects() {
        return Stream.of(
            Arguments.of(Map.of("bb", 2, "a", 2), new Object[] {"a", "bb", "a", "bb"}),
            Arguments.of(
                Map.of("that", 1, "and", 2, "this", 1),
                new Object[] {"this", "and", "that", "and"}
            ),
            Arguments.of(Map.of("код", 3, "bug", 1), new Object[] {"код", "код", "код", "bug"}),
            Arguments.of(Map.of(1, 2, 2, 2), new Object[] {1, 1, 2, 2})
        );
    }
}

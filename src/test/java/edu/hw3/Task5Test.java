package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw3.Task5.IS_NOT_EXIST_SO_COMPARATOR;
import static edu.hw3.Task5.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {
    @ParameterizedTest
    @MethodSource("getContactsAndComparator")
    void check_on_correct_work(String[] contacts, String comparator, String[] correctResult) {
        String[] resultOfWork = parseContacts(contacts, comparator);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }

    private static Stream<Arguments> getContactsAndComparator() {
        return Stream.of(
            Arguments.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC", new String[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"}
            ),
            Arguments.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                "DESC", new String[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getComparators")
    void check_of_work_if_arrays_is_empty(String comparator) {
        String[] resultOfWork = parseContacts(new String[] {}, comparator);

        assertThat(resultOfWork).isEqualTo(new String[] {});
    }

    private static Stream<Arguments> getComparators() {
        return Stream.of(
            Arguments.of("ASC"),
            Arguments.of("DESC")
        );
    }

    @ParameterizedTest
    @MethodSource("getComparators")
    void check_if_array_is_null(String comparator) {
        String[] resultOfWork = parseContacts(null, comparator);

        assertThat(resultOfWork).isEqualTo(new String[] {});
    }

    @ParameterizedTest
    @MethodSource("getIncorrectComparators")
    void throws_if_comparator_isNot_correct(String comparator) {
        var except = assertThrows(IllegalArgumentException.class, () -> parseContacts(null, comparator));

        assertThat(except.getMessage()).isEqualTo(IS_NOT_EXIST_SO_COMPARATOR);
    }

    private static Stream<Arguments> getIncorrectComparators() {
        return Stream.of(
            Arguments.of("DESc"),
            Arguments.of("lmqoeg"),
            Arguments.of("AsC"),
            Arguments.of("asc"),
            Arguments.of("desc"),
            Arguments.of("1324")
        );
    }

    @ParameterizedTest
    @MethodSource("getIsNotFullName")
    void check_if_name_is_not_full(String[] contacts, String comparator, String[] correctResult) {
        String[] resultOfWork = parseContacts(contacts, comparator);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }

    private static Stream<Arguments> getIsNotFullName() {
        return Stream.of(
            Arguments.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene"},
                "ASC", new String[] {"Thomas Aquinas", "David Hume", "John Locke", "Rene"}
            ),
            Arguments.of(new String[] {"Paul Erdos Rene", "Leonhard Euler Rene", "Carl Gauss Rene"},
                "DESC", new String[] {"Carl Gauss Rene", "Leonhard Euler Rene", "Paul Erdos Rene"}
            ),
            Arguments.of(new String[] {"Paul", "Leonhard Euler", "Carl Gauss"},
                "DESC", new String[] {"Paul", "Carl Gauss", "Leonhard Euler"}
            ),
            Arguments.of(new String[] {"Paul Erdos Rene", "Leonhard Euler Rene Rene Rene", "Carl Gauss"},
                "DESC", new String[] {"Carl Gauss", "Leonhard Euler Rene Rene Rene", "Paul Erdos Rene"}
            )
        );
    }
}

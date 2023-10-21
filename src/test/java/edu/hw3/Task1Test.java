package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw3.Task1.atbash;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @MethodSource("getLines")
    void check_diff_line(String line, String resultLine) {
        String resultOfWork = atbash(line);

        assertThat(resultOfWork).isEqualTo(resultLine);
    }

    private static Stream<Arguments> getLines() {
        return Stream.of(
            Arguments.of("Hello world!", "Svool dliow!"),
            Arguments.of(
                "Any fool can write code that a computer" +
                    " can understand. Good programmers write code that humans can understand. ― Martin Fowler",
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh" +
                    " xzm fmwvihgzmw. ― Nzigrm Uldovi"
            ),
            Arguments.of("fnenijgng ksmfknag kengoingirgn", "umvmrqtmt phnupmzt pvmtlrmtritm"),
            Arguments.of("", ""),
            Arguments.of(null, null)
        );
    }
}

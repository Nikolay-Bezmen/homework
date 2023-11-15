package edu.hw6.Task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task2.CloneFile.cloneFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CloneFileTest {
    private static Path pathToDirectory;
    private static Path pathToFile;

    @BeforeEach void setup() throws IOException {
        pathToDirectory = Path.of("directory");
        Files.createDirectory(pathToDirectory);
        pathToFile = pathToDirectory.resolve("Tinkoff Bank Biggest Secret.txt");
        Files.createFile(pathToFile);
    }

    @Disabled
    @Test
    void test_create_correct_copy_file() throws IOException {
        Path copyOfFile = cloneFile(pathToFile);

        assertThat(copyOfFile.getFileName().toString()).isEqualTo("Tinkoff Bank Biggest Secret — копия.txt");

        Files.deleteIfExists(copyOfFile);
    }

    @Disabled
    @Test
    void test_create_correct_not_first_copy_file() throws IOException {
        Path copyOfFileNumberFirst = cloneFile(pathToFile);
        Path copyOfFileNumberSecond = cloneFile(pathToFile);
        assertThat(copyOfFileNumberSecond.getFileName().toString()).isEqualTo(
            "Tinkoff Bank Biggest Secret — копия (2).txt");

        Files.deleteIfExists(copyOfFileNumberFirst);
        Files.deleteIfExists(copyOfFileNumberSecond);
    }

    @AfterEach void clear() throws IOException {
        Files.deleteIfExists(pathToDirectory.resolve("Tinkoff Bank Biggest Secret.txt"));
        Files.deleteIfExists(pathToDirectory);
    }
}

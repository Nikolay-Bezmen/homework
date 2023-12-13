package edu.hw6.Task3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import static edu.hw6.Task3.AbstractFilter.EXECUTABLE;
import static edu.hw6.Task3.AbstractFilter.extension;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.magicNumber;
import static edu.hw6.Task3.AbstractFilter.regexNamePattern;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AbstractFilterTest {
    private static Path directory;

    @BeforeAll static void setup() throws IOException {
        directory = Files.createDirectory(Path.of("directory"));
    }

    @Disabled
    @Test
    void test_filter_for_txt_extension() throws Exception {
        try {
            Files.createFile(directory.resolve("test.txt"));
            Files.createFile(directory.resolve("test.jpg"));
            Files.createFile(directory.resolve("test.png"));

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory, extension("txt"))) {
                int countTXTFiles = 0;
                for (Path entry : stream) {
                    assertThat(entry.getFileName().toString()).endsWith(".txt");
                    ++countTXTFiles;
                }
                assertThat(countTXTFiles).isEqualTo(1);
            }
        } catch (Exception e) {
            Files.deleteIfExists(directory.resolve("test.txt"));
            Files.deleteIfExists(directory.resolve("test.jpg"));
            Files.deleteIfExists(directory.resolve("test.png"));
            Files.deleteIfExists(directory);
        }

        Files.deleteIfExists(directory.resolve("test.txt"));
        Files.deleteIfExists(directory.resolve("test.jpg"));
        Files.deleteIfExists(directory.resolve("test.png"));
    }

    @Test
    void test_filter_for_size() throws IOException {
        try {
            Files.write(directory.resolve("test1.txt"), new byte[200]);
            Files.write(directory.resolve("test2.txt"), new byte[1000]);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory, largerThan(700))) {
                int countCorrectFiles = 0;
                for (Path entry : stream) {
                    assertThat(Files.size(entry)).isGreaterThan(700);
                    ++countCorrectFiles;
                }

                assertThat(countCorrectFiles).isEqualTo(1);
            }
        } catch (Exception e) {
            Files.deleteIfExists(directory.resolve("test1.txt"));
            Files.deleteIfExists(directory.resolve("test2.txt"));
            Files.deleteIfExists(directory);
        }

        Files.deleteIfExists(directory.resolve("test1.txt"));
        Files.deleteIfExists(directory.resolve("test2.txt"));
    }

    @Disabled
    @Test
    void test_if_is_magic_id() throws IOException {
        try {
            byte[] magicNumberForJPG = {(byte) 255, (byte) 216};
            byte[] magicNumberForPNG = {(byte) 0x89, 'P', 'N', 'G'};
            Files.write(directory.resolve("test.jpg"), magicNumberForJPG);
            Files.write(directory.resolve("test.png"), magicNumberForPNG);

            DirectoryStream.Filter<Path> filter = magicNumber(magicNumberForPNG);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory, filter)) {
                int countCorrectFiles = 0;
                for (Path entry : stream) {
                    ++countCorrectFiles;
                    assertThat(filter.accept(entry)).isTrue();
                }

                assertThat(countCorrectFiles).isEqualTo(1);
            }
        } catch (Throwable e) {
            Files.deleteIfExists(directory.resolve("test.jpg"));
            Files.deleteIfExists(directory.resolve("test.png"));
            Files.deleteIfExists(directory);
        }

        Files.deleteIfExists(directory.resolve("test.jpg"));
        Files.deleteIfExists(directory.resolve("test.png"));
    }

    @Disabled
    @Test
    void test_combined_filters() throws IOException {
        try {
            Set<PosixFilePermission> permissionsForExecute = new HashSet<>();
            permissionsForExecute.add(PosixFilePermission.OTHERS_EXECUTE);
            byte[] magicNumberForJPG = {(byte) 255, (byte) 216};
            Path path1 = Files.write(directory.resolve("tinkoff.jpg"), magicNumberForJPG);
            Path path2 = Files.write(directory.resolve("test1.png"), magicNumberForJPG);
            Path path3 = Files.createFile(directory.resolve("test2.txt"));
            Files.setPosixFilePermissions(path1, permissionsForExecute);
            Files.setPosixFilePermissions(path2, permissionsForExecute);
            Files.setPosixFilePermissions(path3, permissionsForExecute);

            DirectoryStream.Filter<Path> filter = magicNumber(magicNumberForJPG)
                .and(extension("jpg"))
                .and(regexNamePattern("tinkoff"))
                .and(EXECUTABLE);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory, filter)) {
                int countCorrectFiles = 0;
                for (Path entry : stream) {
                    ++countCorrectFiles;
                    assertThat(filter.accept(entry)).isTrue();
                }

                assertThat(countCorrectFiles).isEqualTo(1);
            }
        } catch (Throwable e) {
            Files.deleteIfExists(directory.resolve("tinkoff.jpg"));
            Files.deleteIfExists(directory.resolve("test1.png"));
            Files.deleteIfExists(directory.resolve("test2.txt"));
            Files.deleteIfExists(directory);
        }

        Files.deleteIfExists(directory.resolve("tinkoff.jpg"));
        Files.deleteIfExists(directory.resolve("test1.png"));
        Files.deleteIfExists(directory.resolve("test2.txt"));
    }

    @AfterAll static void clear() throws IOException {
        Files.deleteIfExists(directory);
    }
}

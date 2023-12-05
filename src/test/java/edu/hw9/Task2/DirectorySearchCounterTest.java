package edu.hw9.Task2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DirectorySearchCounterTest {
    private static final File mainDirectory = new File("src/test/java/edu/hw9/task2/mainDir");
    @BeforeAll static void prepareDirectoryAndFilesForTests() throws IOException {
        mainDirectory.mkdir();
        File[] files = new File[5];
        String dirName = "dir";
        String fileName = "file";

        for(int i = 0; i < files.length; ++i){
            files[i] = new File(mainDirectory, dirName + i);
            files[i].mkdir();

            for(int j = 0; j < 6; ++j){
                new File(files[i], fileName + j).createNewFile();
            }
        }
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void test_correct_work1(int requiredCountFiles, int correctListSize){
        List<File> stats = FileUtils.findDirectories(mainDirectory, requiredCountFiles);

        assertThat(stats.size()).isEqualTo(correctListSize);
    }

    private static Stream<Arguments> getArguments(){
        return Stream.of(
            Arguments.of(20, 1),
            Arguments.of(5, 6)
        );
    }

    @AfterAll static void clearAllCreatedDirectoryAndFilesInProcessOfTesting(){
        File[] files = mainDirectory.listFiles();

        for(File file : files){
            File[] subFiles = file.listFiles();

            for (File subFile : subFiles){
                subFile.delete();
            }
            file.delete();
        }
        mainDirectory.delete();
    }
}

package edu.hw9.Task2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class FileSearchByPredicatesTest {
    private static final File mainDirectory = new File("mainDir");
    private static final String TXT_EXTENSION = ".txt";
    @BeforeAll static void prepareDirectoryAndFilesForTests() throws IOException {
        mainDirectory.mkdir();
        File[] files = new File[5];
        String dirName = "dir";
        String fileName = "file";

        for(int i = 0; i < files.length; ++i){
            files[i] = new File(mainDirectory, dirName + i);
            files[i].mkdir();

            for(int j = 0; j < 6; ++j){
                File file = new File(files[i], fileName + j + TXT_EXTENSION);
                file.createNewFile();
                try(FileOutputStream fos = new FileOutputStream(file)){
                    fos.write(new byte[1024]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    void test_correct_work_if_correct_files_are_exists(){
        List<File> stats = FileUtils.findFilesByPredicates(mainDirectory, 1000, TXT_EXTENSION);

        assertThat(stats.size()).isEqualTo(30);
    }

    @Test
    void test_if_suitable_files_are_not_exists(){
        List<File> stats = FileUtils.findFilesByPredicates(mainDirectory, 1024 * 1024, TXT_EXTENSION);

        assertThat(stats.size()).isEqualTo(0);
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

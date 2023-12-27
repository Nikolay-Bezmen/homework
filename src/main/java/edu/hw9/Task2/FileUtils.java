package edu.hw9.Task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class FileUtils {
    private FileUtils() {
    }

    public static List<File> findDirectories(File file, int countSubDirectories) {
        try (ForkJoinPool fjp = new ForkJoinPool()) {
            return fjp.invoke(new DirectorySearchCounter(file, countSubDirectories)).getDirectories();
        }
    }

    public static List<File> findFilesByPredicates(File directory, long minFileSize, String requiredExtension) {
        try (ForkJoinPool fjp = new ForkJoinPool()) {
            return fjp.invoke(new FileSearchByPredicates(directory, minFileSize, requiredExtension));
        }
    }
}

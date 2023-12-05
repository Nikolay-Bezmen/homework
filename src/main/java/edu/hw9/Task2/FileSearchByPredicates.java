package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileSearchByPredicates extends RecursiveTask<List<File>> {
    private final File directory;
    private final long minFileSize;
    private final String requiredExtension;

    FileSearchByPredicates(File directory, long minFileSize, String requiredExtension) {
        this.directory = directory;
        this.minFileSize = minFileSize;
        this.requiredExtension = requiredExtension;
    }

    @Override
    protected List<File> compute() {
        File[] files = directory.listFiles();
        List<File> directories = new ArrayList<>();
        List<File> validFiles = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                directories.add(file);
            } else {
                if (isValid(file)) {
                    validFiles.add(file);
                }
            }
        }

        List<FileSearchByPredicates> subDirectories = directories.stream()
            .map(dir -> new FileSearchByPredicates(dir, minFileSize, requiredExtension))
            .peek(ForkJoinTask::fork)
            .toList();

        List<File> validFilesFromSubDirectories = subDirectories.stream()
            .flatMap(dir -> dir.join().stream()).toList();

        validFiles.addAll(validFilesFromSubDirectories);

        return validFiles;
    }

    private boolean isValid(File file) {
        return file.length() > minFileSize && file.getName().endsWith(requiredExtension);
    }

}

package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DirectorySearchCounter extends RecursiveTask<Pair> {
    private final File directory;
    private final int requiredCountFiles;

    DirectorySearchCounter(File directory, int requiredCountFiles) {
        this.directory = directory;
        this.requiredCountFiles = requiredCountFiles;
    }

    @Override
    protected Pair compute() {
        File[] files = directory.listFiles();
        List<File> validDirectories = new ArrayList<>();
        List<File> directories = new ArrayList<>();
        int countFiles = 0;

        for (File file : files) {
            if (file.isDirectory()) {
                directories.add(file);
            } else {
                ++countFiles;
            }
        }

        List<DirectorySearchCounter> subDirectoriesSearch = directories.stream()
            .map(dir -> new DirectorySearchCounter(dir, requiredCountFiles))
            .peek(ForkJoinTask::fork)
            .toList();

        List<Pair> stats = subDirectoriesSearch.stream()
            .map(ForkJoinTask::join)
            .toList();

        for (var stata : stats) {
            if (stata.getCountSubFiles() > requiredCountFiles) {
                validDirectories.addAll(stata.getDirectories());
            }

            countFiles += stata.getCountSubFiles();
        }

        if (countFiles > requiredCountFiles) {
            validDirectories.add(directory);
        }

        return new Pair(validDirectories, countFiles);
    }
}


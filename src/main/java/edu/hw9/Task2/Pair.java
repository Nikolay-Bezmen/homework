package edu.hw9.Task2;

import java.io.File;
import java.util.List;

public class Pair {
    private final int countSubFiles;
    private final List<File> directories;

    public Pair(List<File> directories, int countSubFiles) {
        this.directories = directories;
        this.countSubFiles = countSubFiles;
    }

    public int getCountSubFiles() {
        return countSubFiles;
    }

    public List<File> getDirectories() {
        return directories;
    }
}

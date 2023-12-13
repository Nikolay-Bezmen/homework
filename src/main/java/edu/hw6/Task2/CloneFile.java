package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class CloneFile {
    public static Path cloneFile(Path path) throws IOException {
        String fileName = path.getFileName().toString();
        String baseName = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
        String extension = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : "";
        Path directory = path.getParent();
        int copyNumber = 1;

        Set<String> filesFromDirectory = Arrays.stream(Objects.requireNonNull(directory.toFile().listFiles()))
            .map(File::getName)
            .collect(Collectors.toSet());

        String target;
        do {
            target = baseName + " — копия" + (copyNumber > 1 ? " (" + copyNumber + ")" : "") + extension;
            copyNumber++;
        } while (filesFromDirectory.contains(target));

        Path copy = directory.resolve(Path.of(target));

        return Files.copy(path, copy, StandardCopyOption.COPY_ATTRIBUTES);
    }
}

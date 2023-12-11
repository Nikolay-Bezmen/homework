package edu.hw10.Task1;

import edu.hw10.Task1.annotations.Max;
import edu.hw10.Task1.annotations.Min;
import edu.hw10.Task1.annotations.NotNull;

public record MyRecord(@Min(0) int numberOfRecord,
                       @NotNull String description,
                       @Min(0) int year,
                       @Min(0) @Max(12) int month) {
}

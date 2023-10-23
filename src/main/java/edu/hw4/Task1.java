package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task1 {
    public static List<Animal> sortedByHeight(List<Animal> zoo) {
        return zoo.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }
}

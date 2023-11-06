package edu.hw4;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task1 {
    public static List<Animal> sortedByHeight(List<Animal> zoo) {
        return zoo.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }
}

package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task16 {
    public static List<Animal> sortedByTypeThanBySexThanByName(List<Animal> zoo) {
        return zoo.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .collect(Collectors.toList());
    }
}

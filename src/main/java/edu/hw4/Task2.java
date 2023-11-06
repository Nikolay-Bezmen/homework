package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task2 {
    public static List<Animal> getFirstKAnimalsSortedByWeight(List<Animal> zoo, int k) {
        return zoo.stream()
            .sorted((a, b) -> b.weight() - a.weight())
            .limit(k)
            .collect(Collectors.toList());
    }
}

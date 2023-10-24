package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task6 {
    public static Map<Animal.Type, Animal> getHeaviestAnimalForEachOfType(List<Animal> zoo) {
        return zoo.stream()
            .collect(Collectors.groupingBy(Animal::type)).entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream().max(Comparator.comparingInt(Animal::weight)).get()
            ));
    }
}

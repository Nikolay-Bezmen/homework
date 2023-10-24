package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task3 {
    public static Map<Animal.Type, Integer> getCountAnimalEachOfType(List<Animal> zoo) {
        return zoo.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

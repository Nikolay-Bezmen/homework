package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task5 {
    public static Animal.Sex getMorePopularSex(List<Animal> zoo) {
        var result = zoo.stream()
            .collect(Collectors.groupingBy(animal -> animal.sex(), Collectors.summingInt(animal -> 1)))
            .entrySet()
            .stream()
            .max((a, b) -> a.getValue() - b.getValue());

        if (result.isEmpty()) {
            throw new RuntimeException();
        }

        return result.get().getKey();
    }
}

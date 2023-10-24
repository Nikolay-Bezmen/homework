package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.SPIDER;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task17 {
    public static boolean spidersBitesMoreOftenThanDogs(List<Animal> zoo) {
        return zoo.stream()
            .filter(animal -> animal.type() == DOG || animal.type() == SPIDER)
            .collect(Collectors.groupingBy(animal -> animal.type()))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                e -> e.getKey(),
                e -> (double) e.getValue().stream().filter(a -> a.bites()).count()
                    / (double) e.getValue().stream().count()
            ))
            .entrySet()
            .stream()
            .max((a, b) -> (a.getValue() - b.getValue()) > 0 ? 1 : -1)
            .map(Map.Entry::getKey)
            .get()
            .equals(SPIDER);
    }
}

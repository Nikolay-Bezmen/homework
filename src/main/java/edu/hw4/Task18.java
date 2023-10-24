package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import static edu.hw4.Animal.Type.FISH;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task18 {
    public static Animal getHeaviestFish(List<List<Animal>> chainZoo) {
        return chainZoo.stream()
            .map(listAnimals -> listAnimals.stream()
                .filter(animal -> animal.type() == FISH)
                .max(Comparator.comparingInt(Animal::weight))
                .orElse(null))
            .filter(Objects::nonNull)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }
}

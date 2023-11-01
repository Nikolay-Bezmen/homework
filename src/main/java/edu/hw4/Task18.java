package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static edu.hw4.Animal.Type.FISH;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task18 {
    public static final String FISH_IS_NOT_EXIST = "fish is not exist in zoo";

    public static Animal getHeaviestFish(List<List<Animal>> chainZoo) {
        Optional<Animal> heaviestFish = chainZoo.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type() == FISH)
            .max(Comparator.comparingInt(Animal::weight));

        if (heaviestFish.isEmpty()) {
            throw new RuntimeException(FISH_IS_NOT_EXIST);
        }

        return heaviestFish.get();
    }
}

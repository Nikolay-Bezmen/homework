package edu.hw4;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task8 {
    public static final String THERE_ARE_NO_SUITABLE_ANIMALS = "there are no suitable animals";

    public static Animal getMoreHeavyAnimalAmongAnimalLowerThanK(List<Animal> zoo, int k) {
        Optional<Animal> animal = zoo.stream()
            .filter(a -> a.height() < k)
            .sorted((a, b) -> b.weight() - a.weight())
            .findFirst();

        if (animal.isEmpty()) {
            throw new IndexOutOfBoundsException(THERE_ARE_NO_SUITABLE_ANIMALS);
        }

        return animal.get();
    }
}

package edu.hw4;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task7 {
    public static final String THERE_ARE_NO_SUITABLE_ANIMALS = "there are no suitable animals";

    public static Animal getKMoreOldAnimal(List<Animal> zoo, int k) {
        Optional<Animal> findKmoreOlder = zoo.stream()
            .sorted((a, b) -> b.age() - a.age())
            .skip(k - 1)
            .findFirst();
        if (findKmoreOlder.isEmpty()) {
            throw new IndexOutOfBoundsException(THERE_ARE_NO_SUITABLE_ANIMALS);
        }

        return findKmoreOlder.get();
    }
}

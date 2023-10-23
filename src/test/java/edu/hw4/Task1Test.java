package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw4.Animal.Type.*;
import static edu.hw4.Animal.Sex.*;
import static edu.hw4.Task1.sortedByHeight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void test_sorted_by_height(){
        Animal dog = new Animal("Sharik", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        List<Animal> zoo = new ArrayList<>(List.of(dog, cat, parrot, shark, digger));

        List<Animal> zooSortedByHeight = sortedByHeight(zoo);

        assertThat(zooSortedByHeight).isEqualTo(List.of(digger, parrot, cat, dog, shark));
    }
}

package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task16.sortedByTypeThanBySexThanByName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {
    //CAT - 0, DOG - 1, BIRD - 2, FISH - 3, SPIDER - 4
    //M - 0, F - 1
    @Test
    void test_zoo_sorted_type_than_sex_than_name() {
        Animal dog1 = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 15, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 23, 20, 1, false);
        Animal dog2 = new Animal("Jack", DOG, M, 7, 100, 45, true);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal dog3 = new Animal("Masha", DOG, F, 19, 100, 55, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 2, 1, true);
        Animal dog4 = new Animal("Tazik", DOG, M, 5, 100, 65, true);
        List<Animal> zoo = List.of(dog1, cat, parrot, dog2, shark, dog3, digger, dog4);
        List<Animal> correctResult = List.of(cat, dog2, dog1, dog4, dog3, parrot, shark, digger);

        List<Animal> resultOfWork = sortedByTypeThanBySexThanByName(zoo);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }
}

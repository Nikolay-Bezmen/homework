package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task6.getHeaviestAnimalForEachOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void test_on_get_max_heavy_animal_for_each_of_type(){
        Animal dog1 = new Animal("Sharik1", DOG, M, 15, 100, 35, true);
        Animal dog2 = new Animal("Sharik2", DOG, M, 15, 100, 45, true);
        Animal dog3 = new Animal("Sharik3", DOG, M, 15, 100, 55, true);
        Animal dog4 = new Animal("Sharik4", DOG, M, 15, 100, 49, true);
        Animal cat1 = new Animal("Barsik1", CAT, F, 13, 30, 4, true);
        Animal cat2 = new Animal("Barsik2", CAT, F, 13, 30, 3, true);
        Animal cat3 = new Animal("Barsik3", CAT, F, 13, 30, 7, true);
        Animal cat4 = new Animal("Barsik4", CAT, F, 13, 30, 2, true);
        Animal cat5 = new Animal("Barsik5", CAT, F, 13, 30, 5, true);
        Animal parrot1 = new Animal("Kesha1", BIRD, M, 4,20 , 1, false);
        Animal parrot2 = new Animal("Kesha2", BIRD, M, 4,20 , 2, false);
        Animal shark1 = new Animal("Baby1", FISH, F, 115, 200, 300, true);
        Animal shark2 = new Animal("Baby2", FISH, F, 115, 200, 378, true);
        Animal shark3 = new Animal("Baby3", FISH, F, 115, 200, 567, true);
        Animal shark4 = new Animal("Baby4", FISH, F, 115, 200, 99, true);
        Animal shark5 = new Animal("Baby5", FISH, F, 115, 200, 199, true);
        Animal shark6 = new Animal("Baby6", FISH, F, 115, 200, 345, true);
        Animal shark7 = new Animal("Baby7", FISH, F, 115, 200, 458, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        List<Animal> zoo = List.of(
            dog1, dog2, dog3, dog4,
            cat1, cat2, cat3, cat4, cat5,
            parrot1, parrot2,
            shark1, shark2, shark3, shark4, shark5, shark6, shark7,
            digger
        );
        Map<Animal.Type, Animal> correctResult = Map.of(
            DOG, dog3,
            CAT, cat3,
            BIRD, parrot2,
            FISH, shark3,
            SPIDER, digger
        );

        Map<Animal.Type, Animal> resultOfWork = getHeaviestAnimalForEachOfType(zoo);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }
}

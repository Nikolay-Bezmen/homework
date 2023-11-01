package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task5.getMorePopularSex;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {
    @Test
    void test_get_more_popular_sex(){
        Animal dog1 = new Animal("Sharik1", DOG, M, 15, 100, 35, true);
        Animal dog2 = new Animal("Sharik2", DOG, F, 15, 100, 35, true);
        Animal dog3 = new Animal("Sharik3", DOG, M, 15, 100, 35, true);
        Animal dog4 = new Animal("Sharik4", DOG, M, 15, 100, 35, true);
        Animal cat1 = new Animal("Barsik1", CAT, F, 13, 30, 4, true);
        Animal cat2 = new Animal("Barsik2", CAT, M, 13, 30, 4, true);
        Animal cat3 = new Animal("Barsik3", CAT, F, 13, 30, 4, true);
        Animal cat4 = new Animal("Barsik4", CAT, M, 13, 30, 4, true);
        Animal cat5 = new Animal("Barsik5", CAT, F, 13, 30, 4, true);
        Animal parrot1 = new Animal("Kesha1", BIRD, F, 4,20 , 1, false);
        Animal parrot2 = new Animal("Kesha2", BIRD, M, 4,20 , 1, false);
        Animal shark1 = new Animal("Baby1", FISH, M, 115, 200, 300, true);
        Animal shark2 = new Animal("Baby2", FISH, F, 115, 200, 300, true);
        Animal shark3 = new Animal("Baby3", FISH, M, 115, 200, 300, true);
        Animal shark4 = new Animal("Baby4", FISH, F, 115, 200, 300, true);
        Animal shark5 = new Animal("Baby5", FISH, F, 115, 200, 300, true);
        Animal shark6 = new Animal("Baby6", FISH, F, 115, 200, 300, true);
        Animal shark7 = new Animal("Baby7", FISH, F, 115, 200, 300, true);
        Animal digger1 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        List<Animal> zoo = List.of(
            dog1, dog2, dog3, dog4,
            cat1, cat2, cat3, cat4, cat5,
            parrot1, parrot2,
            shark1, shark2, shark3, shark4, shark5, shark6, shark7,
            digger1
        );

        Animal.Sex resultOfWork = getMorePopularSex(zoo);

        assertThat(resultOfWork).isEqualTo(F);
    }

    @Test
    void throw_except_if_optional_is_empty(){
        List<Animal> zoo = new ArrayList<>();

        assertThrows(RuntimeException.class, () -> getMorePopularSex(zoo));
    }
}

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
import static edu.hw4.Task18.FISH_IS_NOT_EXIST;
import static edu.hw4.Task18.getHeaviestFish;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task18Test {
    @Test
    void test_get_more_heaviest_fish_among_some_zoos() {
        Animal dog = new Animal("Sharik", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, F, 4, 20, 1, false);
        Animal shark1 = new Animal("Baby", FISH, F, 115, 200, 301, true);
        Animal shark2 = new Animal("Baby", FISH, F, 115, 200, 615, true);
        Animal shark3 = new Animal("Baby", FISH, F, 115, 200, 492, true);
        Animal shark4 = new Animal("Baby", FISH, F, 115, 200, 748, true);
        Animal shark5 = new Animal("Baby", FISH, F, 115, 200, 938, true);
        Animal shark6 = new Animal("Baby", FISH, F, 115, 200, 928, true);
        Animal shark7 = new Animal("Baby", FISH, F, 115, 200, 395, true);
        Animal shark8 = new Animal("Baby", FISH, F, 115, 200, 493, true);
        Animal shark9 = new Animal("Baby", FISH, F, 115, 200, 558, true);
        Animal whole1 = new Animal("Kitty", FISH, F, 245, 2000, 23992, true);
        Animal whole2 = new Animal("Kitty", FISH, F, 245, 2000, 72839, true);
        Animal whole3 = new Animal("Kitty", FISH, F, 245, 2000, 16428, true);
        Animal whole4 = new Animal("Kitty", FISH, F, 245, 2000, 9888, true);
        Animal whole5 = new Animal("Kitty", FISH, F, 245, 2000, 39484, true);
        Animal whole6 = new Animal("Kitty", FISH, F, 245, 2000, 17829, true);
        Animal whole7 = new Animal("Kitty", FISH, F, 245, 2000, 56728, true);
        Animal whole8 = new Animal("Kitty", FISH, F, 245, 2000, 29748, true);
        Animal whole9 = new Animal("Kitty", FISH, F, 245, 2000, 31909, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        List<List<Animal>> chainZoo = List.of(
            List.of(dog, cat, parrot),
            List.of(shark1,shark2,shark3,shark4,shark5),
            List.of(shark6, shark7, shark8, shark9),
            List.of(whole1, whole2, whole3, whole4, digger),
            List.of(whole5, whole6, whole7, whole8, whole9)
        );

        Animal resultFish = getHeaviestFish(chainZoo);

        assertThat(resultFish).isEqualTo(whole2);
    }

    @Test
    void throw_if_fishes_is_not_exist_in_zoo(){
        Animal dog = new Animal("Sharik", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, F, 4, 20, 1, false);
        List<List<Animal>> chainZoo = List.of(List.of(dog, cat), List.of(parrot));

        var except = assertThrows(RuntimeException.class, () -> getHeaviestFish(chainZoo));

        assertThat(except.getMessage()).isEqualTo(FISH_IS_NOT_EXIST);
    }
}

package edu.hw4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task11.getAnimalWhichCanBiteAndHaveHeightMoreOneMeter;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task11Test {
    @ParameterizedTest
    @MethodSource("getAnimals")
    void test_filter_height_more_than_one_meter_and_can_not_bites(List<Animal> zoo, List<Animal> correctFilter){
        List<Animal> resultOfFilter = getAnimalWhichCanBiteAndHaveHeightMoreOneMeter(zoo);

        assertThat(resultOfFilter).isEqualTo(correctFilter);
    }

    private static Stream<Arguments> getAnimals(){
        Animal dog = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 4, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark1 = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal shark2 = new Animal("Ivan", FISH, M, 115, 200, 300, false);
        Animal digger1 = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        Animal digger2 = new Animal("Masha", SPIDER, F, 7, 3, 1, false);
        return Stream.of(
            Arguments.of(List.of(dog, cat, parrot, shark1, digger1, digger2),
                List.of()),
            Arguments.of(List.of(dog, cat, parrot, shark1, digger1, digger2, shark2),
                List.of(shark2))
        );
    }

}

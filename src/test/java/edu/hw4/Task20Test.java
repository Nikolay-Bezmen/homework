package edu.hw4;

import edu.hw4.Task20.Animal;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.Task20.Animal.Sex.M;
import static edu.hw4.Task20.Animal.Type.DOG;
import static edu.hw4.Task20.Animal.getGetAllErrors;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    @Test
    void test_get_all_errors_on_dog(){
        Animal dog = new Animal("DOG1", DOG, M, 1000, 1000, 1000, false);
        Set<String> validationErrors = Set.of(
            "Dog's must be bites",
            "Dog's age must be between 0 and 35",
            "Dog's height must be between 0 and 120",
            "Dog's weight must be between 0 and 150"
        );
        Map<String, String> validations = getGetAllErrors();

        assertThat(validations.size()).isEqualTo(1);

        Set<String> correctErrorsLine = null;
        for (var validation: validations.values()){
            correctErrorsLine = Arrays.stream(validation.split("; ")).peek(String::trim).collect(Collectors.toSet());
        }

        assertThat(validationErrors).isEqualTo(correctErrorsLine);

    }
}

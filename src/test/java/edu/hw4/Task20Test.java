package edu.hw4;

import edu.hw4.Task20.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static edu.hw4.Task20.Animal.Sex.M;
import static edu.hw4.Task20.Animal.Type.DOG;
import static edu.hw4.Task20.Animal.getGetAllErrors;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    private final static Logger LOGGER = LogManager.getLogger();
    @Test
    void test_get_all_errors_on_dog(){
        Animal dog = new Animal("DOG1", DOG, M, 1000, 1000, 1000, false);
        String correctErrorsLine = "Dog's must be bites" + "; "
            + "Dog's weight must be between 0 and 150" + "; "
            + "Dog's age must be between 0 and 35" + "; "
            + "Dog's height must be between 0 and 120" + "; ";
        StringBuilder resultValidations = new StringBuilder();

        Map<String, String> validations = getGetAllErrors();

        assertThat(validations.size()).isEqualTo(1);

        for(var validation: validations.entrySet()){
            LOGGER.info(validation.getValue());
            resultValidations.append(validation.getValue());
        }

        assertThat(resultValidations.toString()).isEqualTo(correctErrorsLine);

    }
}

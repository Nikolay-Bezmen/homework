package edu.hw10;

import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomObjectGeneratorTest {

    @Test
    void throws_if_next_object_has_parameter_null(){
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

        assertThrows(Exception.class, () -> randomObjectGenerator.nextObject(null));

    }
}

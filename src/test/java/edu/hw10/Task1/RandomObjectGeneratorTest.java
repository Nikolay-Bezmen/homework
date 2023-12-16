package edu.hw10.Task1;

import edu.hw10.Task1.annotations.IncorrectUsedAnnotations;
import edu.hw10.Task1.annotations.annotationExceptions.AnnotationsError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomObjectGeneratorTest {

    @Test
    void throws_if_next_object_has_parameter_null() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

        assertThrows(Exception.class, () -> randomObjectGenerator.nextObject(null));
    }

    @Test
    @DisplayName("Генератор объектов должен выбрасывать исключения, аннотации несовместимы")
    void test_if_annotations_are_incompatible() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

        var exception = assertThrows(
            Exception.class,
            () -> randomObjectGenerator.nextObject(IncorrectUsedAnnotations.class)
        );

        assertThat(exception.getMessage()).isEqualTo(AnnotationsError.MIN_IS_GREATER_THAN_MAX.message());
    }
}

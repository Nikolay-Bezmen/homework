package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Shape;
import edu.hw2.Task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] shapes() {
        return new Arguments[]{
            Arguments.of(new Rectangle(20, 10), 200),
            Arguments.of(new Square(20), 400)
        };
    }

    @ParameterizedTest
    @MethodSource("shapes")
    void rectangleArea(Shape shape, double area) {

        assertThat(shape.area()).isEqualTo(area);
    }
}

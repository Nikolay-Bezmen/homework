package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    void rectangle_area(){
        Rectangle rectangle = new Rectangle(20, 10);

        rectangle = rectangle.setHeight(20);
        rectangle = rectangle.setWidth(30);

        assertThat(rectangle.area()).isEqualTo(600);
    }

    @Test
    void square_area_if_use_set_hight(){
        Square square = new Square(20);

        square = square.setHeight(30);

        assertThat(square.area()).isEqualTo(900);
    }
    @Test
    void square_area_if_use_set_width(){
        Square square = new Square(20);

        square = square.setWidth(30);

        assertThat(square.area()).isEqualTo(900);
    }

    @Test
    void square_area_if_use_set_side(){
        Square square = new Square(20);

        square = square.setSide(30);

        assertThat(square.area()).isEqualTo(900);
    }
}

package edu.hw2;

import edu.hw2.Task1.Expr.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void constants_test(){
        Constant constant = new Constant(5);

        assertThat(constant.evaluate()).isEqualTo(5);
    }


    @Test
    void negate_test(){
        Constant constant = new Constant(5);
        Negate negate = new Negate(constant);

        assertThat(negate.evaluate()).isEqualTo(-5);
    }

    @Test
    void addition_test(){
        Constant constant1 = new Constant(2);
        Constant constant2 = new Constant(3);
        Addition addition = new Addition(constant1, constant2);

        assertThat(addition.evaluate()).isEqualTo(5);
    }

    @Test
    void exponent_test(){
        Constant constant = new Constant(3);
        Exponent exponent = new Exponent(constant, 3);

        assertThat(exponent.evaluate()).isEqualTo(27);
    }

    @Test
    void multiplication_test(){
        Constant constant1 = new Constant(3);
        Constant constant2 = new Constant(4);

        Multiplication multiplication = new Multiplication(constant1, constant2);

        assertThat(multiplication.evaluate()).isEqualTo(12);
    }
}

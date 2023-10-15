package edu.hw2.Task1;

import edu.hw2.Task1.Expr.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {

        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Expr.Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        LOGGER.info(res + " = " + res.evaluate());
    }
}


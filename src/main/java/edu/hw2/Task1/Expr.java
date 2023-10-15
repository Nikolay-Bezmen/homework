package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr operand) implements Expr {
        public double evaluate() {
            return -operand.evaluate();
        }
    }

    record Exponent(Expr base, int power) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}

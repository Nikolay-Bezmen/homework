package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public final record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public final record Negate(Expr operand) implements Expr {
        public double evaluate() {
            return -operand.evaluate();
        }
    }

    public final record Exponent(Expr base, int power) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    public final record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    public final record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}

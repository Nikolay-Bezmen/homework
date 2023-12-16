package edu.hw10.Task1.annotations;

public class IncorrectUsedAnnotations {
    private int a;

    public IncorrectUsedAnnotations(@Min(5) @Max(4) int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

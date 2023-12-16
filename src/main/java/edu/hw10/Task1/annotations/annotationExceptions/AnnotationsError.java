package edu.hw10.Task1.annotations.annotationExceptions;

public enum AnnotationsError {
    MIN_IS_GREATER_THAN_MAX("Min value must be less or equals Max value");
    private final String message;

    AnnotationsError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}

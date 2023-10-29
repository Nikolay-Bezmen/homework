package edu.hw4.Task20;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

@SuppressWarnings("HideUtilityClassConstructor")
public class AnimalValidator {
    public static Set<ConstraintViolation<edu.hw4.Task20.Animal>> validateAnimal(edu.hw4.Task20.Animal animal) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(animal, getValidationGroups(animal.type()));
    }

    private static Class<?>[] getValidationGroups(edu.hw4.Task20.Animal.Type type) {
        return switch (type) {
            case DOG -> new Class<?>[]{edu.hw4.Task20.Animal.Dog.class};
            case CAT -> new Class<?>[]{edu.hw4.Task20.Animal.Cat.class};
            case FISH -> new Class<?>[]{edu.hw4.Task20.Animal.Fish.class};
            case SPIDER -> new Class<?>[]{edu.hw4.Task20.Animal.Spider.class};
            case BIRD -> new Class<?>[]{Animal.Bird.class};
        };
    }
}

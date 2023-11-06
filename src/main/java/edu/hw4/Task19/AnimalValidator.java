package edu.hw4.Task19;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

@SuppressWarnings("HideUtilityClassConstructor")
public class AnimalValidator {
    public static Set<ConstraintViolation<Animal>> validateAnimal(Animal animal) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(animal, getValidationGroups(animal.type()));
    }

    private static Class<?>[] getValidationGroups(Animal.Type type) {
        return switch (type) {
            case DOG -> new Class<?>[]{Animal.Dog.class};
            case CAT -> new Class<?>[]{Animal.Cat.class};
            case FISH -> new Class<?>[]{Animal.Fish.class};
            case SPIDER -> new Class<?>[]{Animal.Spider.class};
            case BIRD -> new Class<?>[]{Animal.Bird.class};
        };
    }
}

package edu.hw4.Task19;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"InnerTypeLast", "MagicNumber"})
public record Animal(
    @NotNull
    String name,

    @NotNull
    Type type,

    @NotNull
    Sex sex,

    @Max(value = 35, groups = Dog.class, message = "Dog's age must be between 0 and 35")
    @Max(value = 40, groups = Cat.class, message = "Cat's age must be between 0 and 40")
    @Max(value = 150, groups = Spider.class, message = "Spider's age must be between 0 and 150")
    @Max(value = 60, groups = Fish.class, message = "Fish's age must be between 0 and 60")
    @Max(value = 150, groups = Bird.class, message = "Bird's age must be between 0 and 150")
    @Min(value = 0, groups = Dog.class, message = "Dog's age must be between 0 and 35")
    @Min(value = 0, groups = Cat.class, message = "Cat's age must be between 0 and 40")
    @Min(value = 0, groups = Spider.class, message = "Spider's age must be between 0 and 150")
    @Min(value = 0, groups = Fish.class, message = "Fish's age must be between 0 and 60")
    @Min(value = 0, groups = Bird.class, message = "Bird's age must be between 0 and 150")
    int age,

    @Max(value = 120, groups = Dog.class, message = "Dog's height must be between 0 and 120")
    @Max(value = 50, groups = Cat.class, message = "Cat's height must be between 0 and 50")
    @Max(value = 50, groups = Spider.class, message = "Spider's height must be between 0 and 50")
    @Max(value = 5000, groups = Fish.class, message = "Fish's height must be between 0 and 5000")
    @Max(value = 360, groups = Bird.class, message = "Bird's height must be between 0 and 360")
    @Min(value = 0, groups = Dog.class, message = "Dog's height must be between 0 and 120")
    @Min(value = 0, groups = Cat.class, message = "Cat's height must be between 0 and 50")
    @Min(value = 0, groups = Spider.class, message = "Spider's height must be between 0 and 50")
    @Min(value = 0, groups = Fish.class, message = "Fish's height must be between 0 and 5000")
    @Min(value = 0, groups = Bird.class, message = "Bird's height must be between 0 and 360")
    int height,

    @Max(value = 150, groups = Dog.class, message = "Dog's weight must be between 0 and 150")
    @Max(value = 300, groups = Cat.class, message = "Cat's weight must be between 0 and 300")
    @Max(value = 2, groups = Spider.class, message = "Spider's weight must be between 0 and 2")
    @Max(value = 30000, groups = Fish.class, message = "Fish's weight must be between 0 and 30000")
    @Max(value = 160, groups = Bird.class, message = "Bird's weight must be between 0 and 160")
    @Min(value = 0, groups = Dog.class, message = "Dog's weight must be between 0 and 150")
    @Min(value = 0, groups = Cat.class, message = "Cat's weight must be between 0 and 300")
    @Min(value = 0, groups = Spider.class, message = "Spider's weight must be between 0 and 2")
    @Min(value = 0, groups = Fish.class, message = "Fish's weight must be between 0 and 30000")
    @Min(value = 0, groups = Bird.class, message = "Bird's weight must be between 0 and 160")
    int weight,

    @AssertTrue(groups = Dog.class, message = "Dog's must be bites")
    @AssertTrue(groups = Cat.class, message = "Cat's must be bites")
    @AssertTrue(groups = Bird.class, message = "Bird's must be bites")
    boolean bites
) {
    private final static Map<String, Set<ConstraintViolation<Animal>>> ERRORS_CREATE = new HashMap<>();

    public static Map<String, Set<ConstraintViolation<Animal>>> getErrorsCreate() {
        return ERRORS_CREATE;
    }

    public Animal(
        @NotNull
        String name,

        @NotNull
        Type type,

        @NotNull
        Sex sex,

        @Max(value = 35, groups = Dog.class, message = "Dog's age must be between 0 and 35")
        @Max(value = 40, groups = Cat.class, message = "Cat's age must be between 0 and 40")
        @Max(value = 150, groups = Spider.class, message = "Spider's age must be between 0 and 150")
        @Max(value = 60, groups = Fish.class, message = "Fish's age must be between 0 and 60")
        @Max(value = 150, groups = Bird.class, message = "Bird's age must be between 0 and 150")
        @Min(value = 0, groups = Dog.class, message = "Dog's age must be between 0 and 35")
        @Min(value = 0, groups = Cat.class, message = "Cat's age must be between 0 and 40")
        @Min(value = 0, groups = Spider.class, message = "Spider's age must be between 0 and 150")
        @Min(value = 0, groups = Fish.class, message = "Fish's age must be between 0 and 60")
        @Min(value = 0, groups = Bird.class, message = "Bird's age must be between 0 and 150")
        int age,

        @Max(value = 120, groups = Dog.class, message = "Dog's height must be between 0 and 120")
        @Max(value = 50, groups = Cat.class, message = "Cat's height must be between 0 and 50")
        @Max(value = 50, groups = Spider.class, message = "Spider's height must be between 0 and 50")
        @Max(value = 5000, groups = Fish.class, message = "Fish's height must be between 0 and 5000")
        @Max(value = 360, groups = Bird.class, message = "Bird's height must be between 0 and 360")
        @Min(value = 0, groups = Dog.class, message = "Dog's height must be between 0 and 120")
        @Min(value = 0, groups = Cat.class, message = "Cat's height must be between 0 and 50")
        @Min(value = 0, groups = Spider.class, message = "Spider's height must be between 0 and 50")
        @Min(value = 0, groups = Fish.class, message = "Fish's height must be between 0 and 5000")
        @Min(value = 0, groups = Bird.class, message = "Bird's height must be between 0 and 360")
        int height,

        @Max(value = 150, groups = Dog.class, message = "Dog's weight must be between 0 and 150")
        @Max(value = 300, groups = Cat.class, message = "Cat's weight must be between 0 and 300")
        @Max(value = 2, groups = Spider.class, message = "Spider's weight must be between 0 and 2")
        @Max(value = 30000, groups = Fish.class, message = "Fish's weight must be between 0 and 30000")
        @Max(value = 160, groups = Bird.class, message = "Bird's weight must be between 0 and 160")
        @Min(value = 0, groups = Dog.class, message = "Dog's weight must be between 0 and 150")
        @Min(value = 0, groups = Cat.class, message = "Cat's weight must be between 0 and 300")
        @Min(value = 0, groups = Spider.class, message = "Spider's weight must be between 0 and 2")
        @Min(value = 0, groups = Fish.class, message = "Fish's weight must be between 0 and 30000")
        @Min(value = 0, groups = Bird.class, message = "Bird's weight must be between 0 and 160")
        int weight,

        @AssertTrue(groups = Dog.class, message = "Dog's must be bites")
        @AssertTrue(groups = Cat.class, message = "Cat's must be bites")
        @AssertTrue(groups = Bird.class, message = "Bird's must be bites")
        boolean bites
    ) {
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bites = bites;
        checkAnimalThroughAnimalValidator();
    }

    private void checkAnimalThroughAnimalValidator() {
        ERRORS_CREATE.put(this.name, AnimalValidator.validateAnimal(this));
    }

    public enum Sex {
        M, F
    }

    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static void deleteAnimals() {
        ERRORS_CREATE.clear();
    }

    public interface Dog {
    }

    public interface Cat {
    }

    public interface Fish {
    }

    public interface Bird {
    }

    public interface Spider {
    }
}

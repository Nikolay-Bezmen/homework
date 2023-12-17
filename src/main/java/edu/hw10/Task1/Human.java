package edu.hw10.Task1;

import edu.hw10.Task1.annotations.Max;
import edu.hw10.Task1.annotations.Min;
import edu.hw10.Task1.annotations.NotNull;

public class Human {
    private int age;
    private String name;
    private int weight;

    public Human(
        @Min(0) @Max(100) int age,
        @NotNull String name,
        @Min(4) @Max(250) int weight
    ) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(@Min(0) @Max(100) int age) {
        this.age = age;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setWeight(@Min(4) @Max(250) int weight) {
        this.weight = weight;
    }
}

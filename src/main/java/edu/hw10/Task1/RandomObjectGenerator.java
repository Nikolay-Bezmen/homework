package edu.hw10.Task1;

import edu.hw10.Task1.annotations.Max;
import edu.hw10.Task1.annotations.Min;
import edu.hw10.Task1.annotations.NotNull;
import edu.hw10.Task1.annotations.annotationExceptions.AnnotationsAreIncompatible;
import edu.hw10.Task1.annotations.annotationExceptions.AnnotationsError;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class RandomObjectGenerator {
    private final ThreadLocalRandom random;

    public RandomObjectGenerator() {
        this.random = ThreadLocalRandom.current();
    }

    public <T> T nextObject(Class<T> clazz) throws AnnotationsAreIncompatible {
        return nextObject(clazz, null);
    }

    private <T> T nextObject(Class<T> clazz, String methodName) throws AnnotationsAreIncompatible {
        if (methodName != null) {
            try {
                Method method = clazz.getDeclaredMethod(methodName);
                return (T) method.invoke(null, generateArgs(method));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
            return (T) constructor.newInstance(generateArgs(constructor));
        } catch (AnnotationsAreIncompatible e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private Object[] generateArgs(Executable executable) throws AnnotationsAreIncompatible {
        Parameter[] parameters = executable.getParameters();
        Object[] objectsFromParameters = new Object[parameters.length];

        for (int i = 0; i < parameters.length; ++i) {
            objectsFromParameters[i] = generateArg(parameters[i]);
        }

        return objectsFromParameters;

    }

    private Object generateArg(Parameter parameter) throws AnnotationsAreIncompatible {
        Class<?> clazz = parameter.getType();
        Object object = null;

        if (clazz.equals(int.class) || clazz.equals(Integer.class)) {
            object = generateRandomInt(parameter);
        } else if (clazz.equals(double.class) || clazz.equals(Double.class)) {
            object = generateRandomDouble(parameter);
        } else if (clazz.equals(String.class)) {
            object = generateRandomString();
        } else if (clazz.isAnnotationPresent(NotNull.class)) {
            object = generateRandomObject();
        }

        return object;
    }

    private Integer generateRandomInt(Parameter parameter) throws AnnotationsAreIncompatible {
        int minCorrectValue = parameter.isAnnotationPresent(Min.class)
            ? parameter.getAnnotation(Min.class).value() : Integer.MIN_VALUE;
        int maxCorrectValue = parameter.isAnnotationPresent(Max.class)
            ? parameter.getAnnotation(Max.class).value() : Integer.MAX_VALUE;

        if (minCorrectValue > maxCorrectValue) {
            throw new AnnotationsAreIncompatible(AnnotationsError.MIN_IS_GREATER_THAN_MAX.message());
        }

        return random.nextInt(minCorrectValue, maxCorrectValue);
    }

    private Double generateRandomDouble(Parameter parameter) throws AnnotationsAreIncompatible {
        double minCorrectValue = parameter.isAnnotationPresent(Min.class)
            ? parameter.getAnnotation(Min.class).value() : Double.MIN_VALUE;
        double maxCorrectValue = parameter.isAnnotationPresent(Max.class)
            ? parameter.getAnnotation(Max.class).value() : Double.MAX_VALUE;

        if (minCorrectValue > maxCorrectValue) {
            throw new AnnotationsAreIncompatible(AnnotationsError.MIN_IS_GREATER_THAN_MAX.message());
        }

        return random.nextDouble(minCorrectValue, maxCorrectValue);
    }

    private Object generateRandomObject() {
        return new Object();
    }

    private String generateRandomString() {
        int randomLength = random.nextInt(15);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < randomLength; i++) {
            sb.append(random.nextInt(97, 122));
        }

        return sb.toString();
    }
}

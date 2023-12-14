package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("тест класса у которого при помощи байт-кода " +
        "создаётся метод toString() который возвращает 'Hello Buddy'")
    void test_hello_buddy_class() throws InstantiationException, IllegalAccessException {
        String correctWorkMethodToString = "Hello, Buddy!";

        Class<?> clazz = new ByteBuddy().
            subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value(correctWorkMethodToString))
            .make()
            .load(Task1Test.class.getClassLoader())
            .getLoaded();

        Object helloBuddy = clazz.newInstance();
        String resultWorkToStringMethod = helloBuddy.toString();

        assertThat(resultWorkToStringMethod).isEqualTo(correctWorkMethodToString);
    }
}

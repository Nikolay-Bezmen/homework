package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @BeforeAll static void changeMethod() {
        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(MultiplyInterceptor.class))
            .make()
            .load(Task2Test.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

    }

    @ParameterizedTest
    @DisplayName("тестирование изменения поведения класса на лету")
    @MethodSource("getArguments")
    void test_correct_change_method(int a, int b, int correctMultiResult) {
        int resultWork = ArithmeticUtils.sum(a, b);

        assertThat(resultWork).isEqualTo(correctMultiResult);
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(5, 7, 35),
            Arguments.of(100, 100, 10000),
            Arguments.of(-1, 5, -5),
            Arguments.of(0, 1000000, 0)
        );
    }
}

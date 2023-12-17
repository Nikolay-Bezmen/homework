package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
@SuppressWarnings("UncommentedMain")
public class CompareDifferentACCCases {
    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(CompareDifferentACCCases.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(15))
            .build();

        new Runner(options).run();
    }

    private Student student;
    private Method method;
    private MethodHandle methodHandle;
    private Function<Student, String> lambda;

    @Setup
    @SuppressWarnings("MultipleStringLiterals")
    public void setup() throws Throwable {
        student = new Student("Alexander", "Biryukov");
        method = student.getClass().getMethod("name");
        method.setAccessible(true);

        MethodType mt = MethodType.methodType(String.class);
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        methodHandle = publicLookup.findVirtual(Student.class, "name", mt);

        CallSite site = LambdaMetafactory.metafactory(
            MethodHandles.lookup(),
            "apply",
            MethodType.methodType(Function.class),
            MethodType.methodType(Object.class, Object.class),
            methodHandle,
            methodHandle.type()
        );
        lambda = (Function<Student, String>) site.getTarget().invokeExact();
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflectionAccess(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandlesAccess(Blackhole bh) throws Throwable {
        String name = (String) methodHandle.invokeExact(student);
        bh.consume(name);
    }

    @Benchmark
    public void lambdaAccess(Blackhole bh) {
        String name = lambda.apply(student);
        bh.consume(name);
    }
}

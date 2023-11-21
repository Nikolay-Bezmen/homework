package edu.hw7.Task3;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonDataBaseTest {
    @Test
    void test_on_correct_add_method_multithreading_executing() throws InterruptedException {
        PersonDataBase personDataBase = new PersonDataBase();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream.range(1,1000).forEach(i -> executor.submit(() ->
            personDataBase.add(new Person(i,
                        "name" + i,
                        "address" + i,
                        "888888888" + i))));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        IntStream.range(1,1000).forEach(i ->
        {
            assertThat(personDataBase.findByAddress("address" + i).size()).isEqualTo(1);
            assertThat(personDataBase.findByName("name" + i).size()).isEqualTo(1);
            assertThat(personDataBase.findByPhone("888888888" + i).size()).isEqualTo(1);
        });

    }

    @Test
    void test_on_correct_remove_multithreading_executing() throws InterruptedException {
        PersonDataBase personDataBase = new PersonDataBase();
        ExecutorService executorFirst = Executors.newFixedThreadPool(10);

        IntStream.range(1,1000).forEach(i -> executorFirst.submit(() ->
            personDataBase.add(new Person(i,
                "name" + i,
                "address" + i,
                "888888888" + i))));

        executorFirst.shutdown();
        executorFirst.awaitTermination(1, TimeUnit.MINUTES);

        ExecutorService executorSecond = Executors.newFixedThreadPool(10);
        IntStream.range(1,1000).forEach(i -> executorSecond.submit(() ->
            personDataBase.delete(i)));

        executorSecond.shutdown();
        executorSecond.awaitTermination(1, TimeUnit.MINUTES);

        IntStream.range(1,1000).forEach(i ->
        {
            assertThat(personDataBase.findByAddress("address" + i).size()).isEqualTo(0);
            assertThat(personDataBase.findByName("name" + i).size()).isEqualTo(0);
            assertThat(personDataBase.findByPhone("888888888" + i).size()).isEqualTo(0);
        });

    }
}

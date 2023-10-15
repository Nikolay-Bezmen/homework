package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw2.Task3.PopularCommandExecutor.CONNECT_IS_FAULTY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @ParameterizedTest
    @DisplayName("manager = faultymanager, количество попыток не хватает для соединение")
    @MethodSource("getFailAttemptsForConnect")
    void set_faulty_connection(int how_often_success, int maxAttempts){
        var PCM = new PopularCommandExecutor(new FaultyConnectionManager(how_often_success), maxAttempts);
        var except = assertThrows(ConnectionException.class, PCM::updatePackages);
        assertThat(except.getMessage()).isEqualTo(CONNECT_IS_FAULTY);
    }

    private static Stream<Arguments> getFailAttemptsForConnect(){
        return Stream.of(
            Arguments.of(9879, 99),
            Arguments.of(18, 17),
            Arguments.of(7, 0),
            Arguments.of(1, 0),
            Arguments.of(15, 12)
        );
    }

    @ParameterizedTest
    @DisplayName("manager = faultymanager, количество попыток хватает для соединение")
    @MethodSource("getGoodAttemptsForFaultyManagert")
    void set_success_connection(int how_often_success, int maxAttempts){
        assertDoesNotThrow(() ->
            new PopularCommandExecutor(new FaultyConnectionManager(how_often_success), maxAttempts).updatePackages());
    }
    private static Stream<Arguments> getGoodAttemptsForFaultyManagert(){
        return Stream.of(
            Arguments.of(5, 6),
            Arguments.of(18, 28),
            Arguments.of(2, 5),
            Arguments.of(7, 9),
            Arguments.of(7, 8),
            Arguments.of(15, 16)
        );
    }


    @ParameterizedTest
    @MethodSource("getFailSourceForDisplayManager")
    void set_fail_connection_display_connection(int how_often_success, int maxAttempts){
        var PCM = new PopularCommandExecutor(new DefaultConnectionManager(how_often_success), maxAttempts);
        var except = assertThrows(ConnectionException.class, PCM::updatePackages);
        assertThat(except.getMessage()).isEqualTo(CONNECT_IS_FAULTY);
    }

    private static Stream<Arguments> getFailSourceForDisplayManager(){
        return Stream.of(
            Arguments.of(5, 6),
            Arguments.of(18, 28),
            Arguments.of(2, 5),
            Arguments.of(7, 9),
            Arguments.of(7, 8),
            Arguments.of(15, 16)
        );
    }
}

package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
public class Task4Test {
    @ParameterizedTest
    @MethodSource("getArguments")
    void test_calling_info(CallingInfo callingInfo, String methodName, String className){
        assertThat(callingInfo.methodName()).isEqualTo(methodName);
        assertThat(callingInfo.className()).isEqualTo(className);
    }

    private static Stream<Arguments> getArguments(){
        return Stream.of(
            Arguments.of(Helper.get(), "get", "edu.hw2.Task4Test$Helper"),
            Arguments.of(Helper.get1(), "getArguments", "edu.hw2.Task4Test")
            );
    }
    private static class Helper{
        public static CallingInfo get(){
            return  get1();
        }
        public static CallingInfo get1(){
            return CallingInfo.callingInfo();
        }
    }
}

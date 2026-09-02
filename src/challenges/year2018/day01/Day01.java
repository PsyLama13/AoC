package challenges.year2018.day01;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day01 {

    List<String> input = Helper.readInput("year2018/d01.txt");

    @Test
    void part01Stream() {
        int result = input.stream().mapToInt(Integer::parseInt).sum();
        Assertions.assertEquals(408, result);
    }


    @Test
    @Disabled
    void part02Stream() {
        int result = Stream.iterate(
                        Map.entry(
                                input.stream().map(Integer::parseInt).toList(),
                                Map.entry(0, Set.<Integer>of())),
                        s -> Map.entry(
                                s.getKey(),
                                Map.entry(
                                        s.getValue().getKey()
                                                + s.getKey().get(s.getValue().getValue().size() % s.getKey().size()),
                                        Stream.concat(s.getValue().getValue().stream(),
                                                        Stream.of(s.getValue().getKey()))
                                                .collect(Collectors.toUnmodifiableSet()))))
                .filter(s -> s.getValue().getValue().contains(s.getValue().getKey()))
                .findFirst()
                .map(s -> s.getValue().getKey())
                .orElseThrow();
        Assertions.assertEquals(55250, result);
    }

    @Test
    void part01() {
        FrequencyReader frequencyReader = FrequencyReader.fromInputList(input);
        int change = frequencyReader.calculateFrequencyChange();
        Assertions.assertEquals(408, change);
    }

    @Test
    void part02() {
        FrequencyReader frequencyReader = FrequencyReader.fromInputList(input);
        int duplicate = frequencyReader.findFirstDuplicate();
        Assertions.assertEquals(55250, duplicate);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of("+1", "-1"), 0),
                Arguments.of(List.of("+3", "+3", "+4", "-2", "-4"), 10),
                Arguments.of(List.of("-6", "+3", "+8", "+5", "-6"), 5),
                Arguments.of(List.of("+7", "+7", "-2", "-7", "-4"), 14)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void part2Test1(List<String> inputList, int expectedResult) {
        FrequencyReader frequencyReader = FrequencyReader.fromInputList(inputList);
        int firstDuplicate = frequencyReader.findFirstDuplicate();
        Assertions.assertEquals(expectedResult, firstDuplicate);
    }
}

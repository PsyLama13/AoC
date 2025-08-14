package katas.yatzy.test;


import katas.yatzy.main.yatzy1.Yatzy1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Yatzy1Test {

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataChance() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(15, List.of(2, 3, 4, 5, 1)),
                org.junit.jupiter.params.provider.Arguments.of(16, List.of(3, 3, 4, 5, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataChance")
    void testChanceScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.chance(dice));
    }


    static Stream<org.junit.jupiter.params.provider.Arguments> testDataYatzy() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(50, List.of(4, 4, 4, 4, 4)),
                org.junit.jupiter.params.provider.Arguments.of(50, List.of(6, 6, 6, 6, 6)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(6, 6, 6, 6, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataYatzy")
    void testYatzyScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getYatzyScore(dice));
    }


    static Stream<org.junit.jupiter.params.provider.Arguments> testDataOnes() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(1, List.of(1, 2, 3, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(2, List.of(1, 2, 1, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(6, 2, 2, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(4, List.of(1, 2, 1, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataOnes")
    void testOnesScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getOnesScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataTwos() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(4, List.of(1, 2, 3, 2, 6)),
                org.junit.jupiter.params.provider.Arguments.of(10, List.of(2, 2, 2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataTwos")
    public void testTwosScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getTwosScore(dice));
    }


    static Stream<org.junit.jupiter.params.provider.Arguments> testDataThrees() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(6, List.of(1, 2, 3, 2, 3)),
                org.junit.jupiter.params.provider.Arguments.of(12, List.of(2, 3, 3, 3, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataThrees")
    public void testThreesScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getThreesScore(dice));
    }


    static Stream<org.junit.jupiter.params.provider.Arguments> testDataFours() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(12, List.of(4, 4, 4, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(8, List.of(4, 4, 5, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(4, List.of(4, 5, 5, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataFours")
    public void testFoursScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getFoursScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataFives() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(10, List.of(4, 4, 4, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(15, List.of(4, 4, 5, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(20, List.of(4, 5, 5, 5, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataFives")
    public void testFivesScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getFivesScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataSixes() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(4, 4, 4, 5, 3)),
                org.junit.jupiter.params.provider.Arguments.of(6, List.of(4, 4, 6, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(18, List.of(6, 5, 6, 6, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataSixes")
    public void testSixesScore(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getSixesScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataOnePair() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(6, List.of(3, 4, 3, 5, 6)),
                org.junit.jupiter.params.provider.Arguments.of(10, List.of(5, 3, 3, 3, 5)),
                org.junit.jupiter.params.provider.Arguments.of(12, List.of(5, 3, 6, 6, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataOnePair")
    public void testOnePair(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getOnePairScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataTwoPairs() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(16, List.of(3, 3, 5, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(16, List.of(3, 3, 5, 5, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(3, 3, 3, 3, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(1, 2, 3, 3, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataTwoPairs")
    public void testTwoPairs(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getTwoPairsScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataThreeOfAKind() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(3, 3, 5, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(15, List.of(5, 3, 5, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(9, List.of(3, 3, 3, 3, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataThreeOfAKind")
    public void testThreeOfAKind(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getThreeOfAKindScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataFourOfAKind() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(12, List.of(3, 3, 3, 3, 5)),
                org.junit.jupiter.params.provider.Arguments.of(20, List.of(5, 5, 5, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(5, 3, 1, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataFourOfAKind")
    public void testFourOfAKind(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getFourOfAKindScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataSmallStraight() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(15, List.of(1, 2, 3, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(15, List.of(2, 3, 4, 5, 1)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(1, 2, 2, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(2, 4, 3, 6, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataSmallStraight")
    public void smallStraight(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getSmallStraightScore(dice));
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> testDataLargeStraight() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(20, List.of(6, 2, 3, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(20, List.of(2, 3, 4, 5, 6)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(1, 2, 3, 4, 5)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(1, 2, 2, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataLargeStraight")
    public void largeStraight(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getLargeStraightScore(dice));
    }


    static Stream<org.junit.jupiter.params.provider.Arguments> testDataFullHouse() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(18, List.of(6, 2, 2, 2, 6)),
                org.junit.jupiter.params.provider.Arguments.of(21, List.of(6, 3, 3, 3, 6)),
                org.junit.jupiter.params.provider.Arguments.of(0, List.of(2, 3, 4, 5, 6))
        );
    }
    @ParameterizedTest
    @MethodSource("testDataFullHouse")
    public void fullHouse(int expectedScore, List<Integer> dice) {
        assertEquals(expectedScore, Yatzy1.getFullHouseScore(dice));
    }
}
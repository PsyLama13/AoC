package challenges.year2018.day02;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class Day02 {
    List<String> debug = Helper.readInput("year2018/d02d.txt");
    List<String> debug2 = Helper.readInput("year2018/d02d2.txt");
    List<String> input = Helper.readInput("year2018/d02.txt");

    @Test
    void part01() {
        ChecksumCalculator checksumCalculator = ChecksumCalculator.fromInputList(input);
        Assertions.assertEquals(7410, checksumCalculator.getCheckSum());
    }

    @Test
    void part02() {
        ChecksumCalculator checksumCalculator = ChecksumCalculator.fromInputList(input);
        Assertions.assertEquals("cnjxoritzhvbosyewrmqhgkul", checksumCalculator.getProtoName());
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcdef", false, false),
                Arguments.of("bababc", true, true),
                Arguments.of("abbcde", true, false),
                Arguments.of("abcccd", false, true),
                Arguments.of("aabcdd", true, false),
                Arguments.of("abcdee", true, false),
                Arguments.of("ababab", false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testStrings(String input, boolean hasDoubles, boolean hasTriples) {
        Box box = new Box(input);
        Assertions.assertEquals(hasDoubles, box.hasDoubles());
        Assertions.assertEquals(hasTriples, box.hasTriples());
    }

    @Test
    void part01Test() {
        ChecksumCalculator checksumCalculator = ChecksumCalculator.fromInputList(debug);
        Assertions.assertEquals(12, checksumCalculator.getCheckSum());
    }

    @Test
    void part02Test() {
        ChecksumCalculator checksumCalculator = ChecksumCalculator.fromInputList(debug2);
        String protoName = checksumCalculator.getProtoName();
        Assertions.assertEquals("fgij", protoName);
    }

}

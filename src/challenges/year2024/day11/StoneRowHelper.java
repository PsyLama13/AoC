package challenges.year2024.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoneRowHelper {
    private final List<Long> numbers = new ArrayList<>();
    private static final Map<String, Long> cache = new HashMap<>();

    public StoneRowHelper(List<String> debug) {
        for (String s : debug.get(0).split(" ")) {
            long num = Long.parseLong(s);
            numbers.add(num);
        }
    }

    public long calcNumbersAfterIterations(int iterations) {
        long total = 0;

        for (long num : numbers) {
            total += processNumber(num, iterations);
        }
        return total;
    }

    private long processNumber(long num, int iterations) {
        if (iterations == 0) {
            return 1;
        }

        String cacheKey = num + "," + iterations;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        long resultCount;
        if (num == 0) {
            resultCount = processNumber(1L, iterations - 1);
        } else if (hasEvenNumberOfDigits(num)) {
            long[] split = splitNumberInHalf(num);
            resultCount = processNumber(split[0], iterations - 1) + processNumber(split[1], iterations - 1);
        } else {
            resultCount = processNumber(num * 2024, iterations - 1);
        }
        cache.put(cacheKey, resultCount);
        return resultCount;
    }

    private static long[] splitNumberInHalf(long number) {
        int digitCount = (int) Math.log10(Math.abs(number)) + 1;
        int halfDigits = digitCount / 2;
        long divisor = (long) Math.pow(10, halfDigits);

        long leftHalf = number / divisor;
        long rightHalf = number % divisor;

        return new long[]{leftHalf, rightHalf};
    }

    private static int digitCount(long num) {
        return (int) Math.log10(num) + 1;
    }

    private static boolean hasEvenNumberOfDigits(long num) {
        return digitCount(num) % 2 == 0;
    }
}

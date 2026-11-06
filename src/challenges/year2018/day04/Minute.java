package challenges.year2018.day04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A minute within the midnight hour (00:00 - 00:59).
 */
public record Minute(int value) {
    private static final int MINUTES_PER_HOUR = 60;

    public Minute {
        if (value < 0 || value >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Minute must be between 0 and 59, was " + value);
        }
    }

    public static Stream<Minute> all() {
        return IntStream.range(0, MINUTES_PER_HOUR).mapToObj(Minute::new);
    }

    public boolean isBefore(Minute other) {
        return value < other.value;
    }
}

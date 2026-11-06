package challenges.year2018.day04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A single observation written on the closet walls, e.g. "[1518-11-01 00:05] falls asleep".
 */
public sealed interface Observation {
    DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    LocalDateTime timestamp();

    static Observation parse(String line) {
        LocalDateTime timestamp = LocalDateTime.parse(line.substring(1, 17), TIMESTAMP_FORMAT);
        String message = line.substring(19);

        return switch (ObservationType.of(message)) {
            case BEGINS_SHIFT -> new BeginsShift(timestamp, parseGuardId(message));
            case FALLS_ASLEEP -> new FallsAsleep(timestamp);
            case WAKES_UP -> new WakesUp(timestamp);
        };
    }

    // "Guard #10 begins shift" -> 10
    private static GuardId parseGuardId(String message) {
        int start = message.indexOf('#') + 1;
        int end = message.indexOf(' ', start);
        return new GuardId(Integer.parseInt(message.substring(start, end)));
    }

    record BeginsShift(LocalDateTime timestamp, GuardId guardId) implements Observation {
    }

    record FallsAsleep(LocalDateTime timestamp) implements Observation {
        public Minute minute() {
            return new Minute(timestamp.getMinute());
        }
    }

    record WakesUp(LocalDateTime timestamp) implements Observation {
        public Minute minute() {
            return new Minute(timestamp.getMinute());
        }
    }
}

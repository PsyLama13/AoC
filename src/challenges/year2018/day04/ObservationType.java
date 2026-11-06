package challenges.year2018.day04;

import java.util.Arrays;

/**
 * The kinds of observations written on the closet walls.
 */
public enum ObservationType {
    BEGINS_SHIFT("Guard #"),
    FALLS_ASLEEP("falls asleep"),
    WAKES_UP("wakes up");

    private final String messagePrefix;

    ObservationType(String messagePrefix) {
        this.messagePrefix = messagePrefix;
    }

    public static ObservationType of(String message) {
        return Arrays.stream(values())
                .filter(type -> message.startsWith(type.messagePrefix))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown observation: " + message));
    }
}

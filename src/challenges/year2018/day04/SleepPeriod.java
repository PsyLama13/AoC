package challenges.year2018.day04;

/**
 * A period during a shift in which the guard is asleep.
 *
 * @param from minute the guard falls asleep (counts as asleep)
 * @param to   minute the guard wakes up (counts as awake)
 */
public record SleepPeriod(Minute from, Minute to) {
    public SleepPeriod {
        if (!from.isBefore(to)) {
            throw new IllegalArgumentException("Sleep period must end after it starts: " + from + " -> " + to);
        }
    }

    public boolean contains(Minute minute) {
        return !minute.isBefore(from) && minute.isBefore(to);
    }

    public int duration() {
        return to.value() - from.value();
    }
}

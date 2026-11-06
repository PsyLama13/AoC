package challenges.year2018.day04;

import java.util.Comparator;
import java.util.List;

public record Guard(GuardId id, List<Shift> shifts) {
    public Guard {
        shifts = List.copyOf(shifts);
    }

    public int totalMinutesAsleep() {
        return shifts.stream().mapToInt(Shift::minutesAsleep).sum();
    }

    public int frequencyAsleepAt(Minute minute) {
        return (int) shifts.stream().filter(shift -> shift.isAsleepAt(minute)).count();
    }

    public Minute minuteMostAsleep() {
        return Minute.all()
                .max(Comparator.comparingInt(this::frequencyAsleepAt))
                .orElseThrow();
    }
}

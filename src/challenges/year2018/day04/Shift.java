package challenges.year2018.day04;

import challenges.year2018.day04.Observation.BeginsShift;
import challenges.year2018.day04.Observation.FallsAsleep;
import challenges.year2018.day04.Observation.WakesUp;

import java.util.ArrayList;
import java.util.List;

public record Shift(GuardId guardId, List<SleepPeriod> sleepPeriods) {
    public Shift {
        sleepPeriods = List.copyOf(sleepPeriods);
    }

    /**
     * Builds a shift from the observation that begins it and the sleep/wake observations that follow.
     */
    public static Shift from(BeginsShift start, List<Observation> observations) {
        List<SleepPeriod> sleepPeriods = new ArrayList<>();
        Minute asleepSince = null;
        for (Observation observation : observations) {
            switch (observation) {
                case FallsAsleep fallsAsleep -> asleepSince = fallsAsleep.minute();
                case WakesUp wakesUp -> {
                    if (asleepSince == null) {
                        throw new IllegalArgumentException("Guard wakes up without having fallen asleep: " + wakesUp);
                    }
                    sleepPeriods.add(new SleepPeriod(asleepSince, wakesUp.minute()));
                    asleepSince = null;
                }
                case BeginsShift other -> throw new IllegalArgumentException(
                        "A shift cannot contain another shift start: " + other);
            }
        }
        return new Shift(start.guardId(), sleepPeriods);
    }

    public boolean isAsleepAt(Minute minute) {
        return sleepPeriods.stream().anyMatch(period -> period.contains(minute));
    }

    public int minutesAsleep() {
        return sleepPeriods.stream().mapToInt(SleepPeriod::duration).sum();
    }
}

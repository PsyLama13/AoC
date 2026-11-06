package challenges.year2018.day04;

import java.util.Comparator;
import java.util.List;

/**
 * The guard post outside the prototype suit lab, with all guards observed there.
 */
public class GuardPost {
    private final List<Guard> guards;

    public GuardPost(List<String> observations) {
        this.guards = new Observations(observations).guards();
    }

    /**
     * Strategy 1: find the guard that has the most minutes asleep,
     * then the minute that guard spends asleep the most.
     */
    public Choice strategyOne() {
        Guard guard = guards.stream()
                .max(Comparator.comparingInt(Guard::totalMinutesAsleep))
                .orElseThrow();
        return new Choice(guard, guard.minuteMostAsleep());
    }

    /**
     * Strategy 2: of all guards, find the one most frequently asleep on the same minute.
     */
    public Choice strategyTwo() {
        Guard guard = guards.stream()
                .max(Comparator.comparingInt(g -> g.frequencyAsleepAt(g.minuteMostAsleep())))
                .orElseThrow();
        return new Choice(guard, guard.minuteMostAsleep());
    }
}

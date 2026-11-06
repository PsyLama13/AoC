package challenges.year2018.day04;

import challenges.year2018.day04.Observation.BeginsShift;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Everything written on the closet walls: parses the observations, organizes them
 * chronologically and turns them into shifts and guards.
 */
public class Observations {
    private final List<Shift> shifts;
    private final List<Guard> guards;

    public Observations(List<String> lines) {
        List<Observation> observations = lines.stream()
                .map(Observation::parse)
                .sorted(Comparator.comparing(Observation::timestamp))
                .toList();
        this.shifts = toShifts(observations);
        this.guards = toGuards(shifts);
    }

    public List<Shift> shifts() {
        return shifts;
    }

    public List<Guard> guards() {
        return guards;
    }

    private static List<Shift> toShifts(List<Observation> observations) {
        List<Shift> shifts = new ArrayList<>();
        BeginsShift currentStart = null;
        List<Observation> currentObservations = new ArrayList<>();

        for (Observation observation : observations) {
            if (observation instanceof BeginsShift start) {
                if (currentStart != null) {
                    shifts.add(Shift.from(currentStart, currentObservations));
                }
                currentStart = start;
                currentObservations = new ArrayList<>();
            } else {
                currentObservations.add(observation);
            }
        }
        if (currentStart != null) {
            shifts.add(Shift.from(currentStart, currentObservations));
        }
        return List.copyOf(shifts);
    }

    private static List<Guard> toGuards(List<Shift> shifts) {
        return shifts.stream()
                .collect(Collectors.groupingBy(Shift::guardId))
                .entrySet().stream()
                .map(entry -> new Guard(entry.getKey(), entry.getValue()))
                .toList();
    }
}

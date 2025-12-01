package katas.racingcar.leaderboard.main;

import java.util.*;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : this.races) {
            for (Driver driver : race.getResults()) {
                String driverName = race.getDriverName(driver);
                int points = race.getPoints(driver);
                results.put(driverName, results.getOrDefault(driverName, 0) + points);
            }
        }
        return results;
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        resultsList.sort(new DriverByPointsDescendingComparator(results));
        return resultsList;
    }

    private record DriverByPointsDescendingComparator(Map<String, Integer> results) implements Comparator<String> {

        @Override
            public int compare(String driverName1, String driverName2) {
                return -results.get(driverName1).compareTo(results.get(driverName2));
            }
        }
}

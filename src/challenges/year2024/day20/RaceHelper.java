package challenges.year2024.day20;

import helper.Coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceHelper {
    Map<Coordinate, Field> map = new HashMap<>();
    Map<Coordinate, Integer> costMap = new HashMap<>();
    Coordinate start;
    Coordinate end;
    int maxX;
    int maxY;

    public RaceHelper(List<String> input) {
        maxX = input.get(0).length();
        maxY = input.size();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                char character = input.get(y).charAt(x);
                Coordinate coordinate = new Coordinate(x, y);
                switch (character) {
                    case 'S' -> {
                        map.put(coordinate, Field.OPEN);
                        start = coordinate;
                    }
                    case 'E' -> {
                        map.put(coordinate, Field.OPEN);
                        end = coordinate;
                    }
                    case '#' -> map.put(coordinate, Field.WALL);
                    case '.' -> map.put(coordinate, Field.OPEN);
                    default -> throw new IllegalStateException("Unexpected value: " + character);
                }
            }
        }
    }

    long calc1(){
        Map<Coordinate, Integer> map = distanceMap();
        return countGoodCheats(distanceMap(), 2);
    }

    Map<Coordinate, Integer> distanceMap() {
        Map<Coordinate, Integer> distanceMap = new HashMap<>();
        Coordinate pos = start;
        int distance = 0;
        do {
            distanceMap.put(pos, distance++);
            pos = pos.getFourNeighbours().stream().filter(i -> !map.containsKey(i) && !map.get(i).equals(Field.WALL) && !distanceMap.containsKey(i)).findFirst().orElse(null);
        } while (pos != null);
        return distanceMap;
    }

    long countGoodCheats(Map<Coordinate, Integer> distances, int maxCheatDuration) {
        Map<List<Coordinate>, Integer> cheats = new HashMap<>();
        for (Map.Entry<Coordinate, Integer> e : distances.entrySet()) {
            Coordinate cheatStart = e.getKey();
            int distance = e.getValue();
            for (int cheatDuration = 2; cheatDuration <= maxCheatDuration; cheatDuration++) {
                for (Coordinate cheatEnd : cheatStart.getNeighboursInDistance(cheatDuration)) {
                    Integer newDistance = distances.get(cheatEnd);
                    if (newDistance != null) {
                        cheats.put(List.of(cheatStart, cheatEnd), newDistance - distance - cheatDuration);
                    }
                }
            }
        }
        return cheats.entrySet().stream().filter(e -> e.getValue() >= 100).count();
    }
}

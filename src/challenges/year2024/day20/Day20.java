package challenges.year2024.day20;

import helper.Coordinate;
import helper.Helper;

import java.util.*;
import java.util.function.Predicate;

public class Day20 {
    private Day20() {
        throw new IllegalArgumentException("utility class");
    }

    static void main() {
        new Puzzle().solve();
    }
}

class Puzzle {
    private final Grid grid;

    Puzzle() {
        grid = Grid.from(Helper.readInput("year2024/d20.txt"));
    }

    void solve() {
        var map = grid.distanceMap();
        IO.println(grid.countGoodCheats(map, 2));
        IO.println(grid.countGoodCheats(map, 20));
    }
}

record Grid(int width, int height, Set<Coordinate> walls, Coordinate start, Coordinate finish) {
    static Grid from(List<String> lines) {
        if (lines == null) {
            return null;
        }
        Set<Coordinate> walls = new HashSet<>();
        Coordinate start = null;
        Coordinate end = null;
        int y = 0;
        int x = 0;
        for (String line : lines) {
            x = 0;
            for (char c : line.toCharArray()) {
                switch (c) {
                    case 'S' -> start = new Coordinate(x, y);
                    case 'E' -> end = new Coordinate(x, y);
                    case '#' -> walls.add(new Coordinate(x, y));
                    case '.' -> { //do nothing on purpose
                    }
                    default -> throw new IllegalArgumentException();
                }
                x++;
            }
            ++y;
        }
        return new Grid(x, y, walls, Objects.requireNonNull(start), Objects.requireNonNull(end));
    }

    Map<Coordinate, Integer> distanceMap() {
        Map<Coordinate, Integer> distanceMap = new HashMap<>();
        Coordinate pos = start;
        int distance = 0;
        do {
            distanceMap.put(pos, distance++);
            pos = pos.getFourNeighbours().stream().filter(Predicate.not(walls::contains)).filter(Predicate.not(distanceMap::containsKey)).findFirst().orElse(null);
        } while (pos != null);
        return distanceMap;
    }

    long countGoodCheats(Map<Coordinate, Integer> distances, int maxCheatDuration) {
        Map<List<Coordinate>, Integer> cheats = new HashMap<>();
        for (Map.Entry<Coordinate, Integer> e : distances.entrySet()) {
            Coordinate cheatStart = e.getKey();
            int distance = e.getValue();
            for (int cheatDuration = 2; cheatDuration <= maxCheatDuration; cheatDuration++) {
                for (var cheatEnd : cheatStart.getNeighboursInDistance(cheatDuration)) {
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
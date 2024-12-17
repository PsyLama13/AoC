package challenges.year2024.day16;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class MazeSolver {
    Coordinate start;
    Coordinate end;
    int maxX;
    int maxY;
    Map<Coordinate, FieldType> map = new HashMap<>();

    public MazeSolver(List<String> input) {
        maxX = input.get(0).length();
        maxY = input.size();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                Character c = input.get(y).charAt(x);
                FieldType type;
                switch (c) {
                    case '#' -> type = FieldType.WALL;
                    case '.', 'S', 'E' -> type = FieldType.OPEN;
                    default -> throw new IllegalStateException("Unexpected value: " + c);
                }
                map.put(new Coordinate(x, y), type);
                if (c == 'S') {
                    start = new Coordinate(x, y);
                }
                if (c == 'E') {
                    end = new Coordinate(x, y);
                }
            }
        }
    }

    public int calc1() {

        PriorityQueue<MazeKey> pq = new PriorityQueue<>();
        MazeKey startKey = new MazeKey(start, Direction.RIGHT, 0, List.of(start));
        pq.add(startKey);

        Map<CompositeKey, Integer> visited = new HashMap<>();
        visited.put(new CompositeKey(start, Direction.RIGHT), startKey.cost);

        while (!pq.isEmpty()) {
            MazeKey current = pq.poll();

            if (current.coordinate.equals(end)) {
                return current.cost;
            }

            List<MazeKey> successors = getSuccessors(current);

            for (MazeKey successor : successors) {
                CompositeKey key = new CompositeKey(successor.coordinate, successor.direction);
                Integer cost = visited.get(key);

                if (cost == null || cost > successor.cost) {
                    visited.put(key, successor.cost);
                    pq.add(successor);
                }
            }
        }

        return -1;
    }

    public int calc2() {
        PriorityQueue<MazeKey> pq = new PriorityQueue<>();
        MazeKey startKey = new MazeKey(start, Direction.RIGHT, 0, List.of(start));
        pq.add(startKey);
        List<MazeKey> ends = new ArrayList<>();

        Map<CompositeKey, List<MazeKey>> visited = new HashMap<>();
        visited.put(new CompositeKey(start, Direction.RIGHT), List.of(startKey));
        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            MazeKey current = pq.poll();

            if (current.cost > minCost) {
                continue;
            }

            if (current.coordinate.equals(end)) {
                if (current.cost < minCost) {
                    minCost = current.cost;
                    ends.clear();
                }
                if (current.cost == minCost) {
                    ends.add(current);
                }
            }

            List<MazeKey> successors = getSuccessors(current);

            for (MazeKey successor : successors) {
                CompositeKey key = new CompositeKey(successor.coordinate, successor.direction);

                boolean isBetterPath = visited.get(key) == null || visited.get(key).stream().allMatch(p->p.cost > successor.cost);

                if (isBetterPath) {
                    visited.computeIfAbsent(key, k -> new ArrayList<>()).add(successor);
                    pq.add(successor);
                }
            }
        }

        Set<Coordinate> output = new HashSet<>();
        List<MazeKey> minimum = getMin(ends);
        for (MazeKey mk : minimum) {
            output.addAll(mk.history);
        }
        printPath(output);
        return output.size();
    }

    private void printPath(Set<Coordinate> output) {
        for (int y = 0; y < maxY; y++) {
            StringBuilder s = new StringBuilder();
            for (int x = 0; x < maxX; x++) {
                Coordinate c = new Coordinate(x, y);
                if (output.contains(c)) {
                    s.append("O");
                } else if (map.get(c).equals(FieldType.WALL)) {
                    s.append("#");
                } else {
                    s.append(".");
                }
            }
            System.out.println(s);
        }
    }

    private List<MazeKey> getMin(List<MazeKey> ends) {
        return ends.stream().min(Comparator.comparingInt(e -> e.cost)).stream().toList();
    }

    private List<MazeKey> getSuccessors(MazeKey current) {
        List<MazeKey> output = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Coordinate c = current.coordinate.getNeighbourInDirection(direction);
            if (map.get(c) != null && !map.get(c).equals(FieldType.WALL)) {
                int cost = current.cost + 1;
                cost = cost + getTurnCost(direction, current.direction);
                List<Coordinate> h = new ArrayList<>(current.history);
                h.add(c);
                output.add(new MazeKey(c, direction, cost, h));
            }
        }
        return output;
    }

    private int getTurnCost(Direction direction, Direction currentDirection) {
        switch (direction) {
            case UP -> {
                return switch (currentDirection) {
                    case UP -> 0;
                    case DOWN -> 2000;
                    case LEFT -> 1000;
                    case RIGHT -> 1000;
                };
            }
            case DOWN -> {
                return switch (currentDirection) {
                    case UP -> 2000;
                    case DOWN -> 0;
                    case LEFT -> 1000;
                    case RIGHT -> 1000;
                };
            }
            case LEFT -> {
                return switch (currentDirection) {
                    case UP -> 1000;
                    case DOWN -> 1000;
                    case LEFT -> 0;
                    case RIGHT -> 2000;
                };
            }
            case RIGHT -> {
                return switch (currentDirection) {
                    case UP -> 1000;
                    case DOWN -> 1000;
                    case LEFT -> 2000;
                    case RIGHT -> 0;
                };
            }
        }
        throw new IllegalStateException();
    }
}

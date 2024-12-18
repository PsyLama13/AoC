package challenges.year2024.day16;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class MazeHelper {
    Coordinate start;
    Coordinate end;
    Map<Coordinate, FieldType> map = new HashMap<>();
    int maxX;
    int maxY;

    public MazeHelper(List<String> input) {
        maxX = input.get(0).length();
        maxY = input.size();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                char c = input.get(y).charAt(x);
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

    public int calc2() {
        State starter = new State(start, Direction.RIGHT, 0, new ArrayList<>(Collections.singleton(start)));
        Set<MapKey> visited = new HashSet<>();
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(starter);
        List<State> ends = new ArrayList<>();
        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (current.getCoordinate().equals(end)) {
                ends.add(current);
            }
            visited.add(new MapKey(current.getCoordinate(), current.getDirection()));
            List<State> successors = getSuccessors(current);
            for (State successor : successors) {
                MapKey successorKey = new MapKey(successor.getCoordinate(), successor.getDirection());
                if (!visited.contains(successorKey)) {
                    pq.add(successor);
                }
            }
        }
        List<State> minimums = getMinimumEndPaths(ends);
        Set<Coordinate> seats = new HashSet<>();
        for (State min : minimums) {
            seats.addAll(min.getHistory());
        }
        return seats.size();
    }

    private List<State> getMinimumEndPaths(List<State> ends) {
        Optional<Integer> minimumCost = ends.stream().map(State::getCost).min(Integer::compareTo);
        if (minimumCost.isPresent()) {
            return ends.stream().filter(i -> i.getCost() == minimumCost.get()).toList();
        }
        throw new IllegalStateException();
    }

    private List<State> getSuccessors(State state) {
        List<State> output = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (!state.getDirection().isOppositeDirection(direction)) {
                Coordinate next = state.getCoordinate().getNeighbourInDirection(direction);
                if (map.containsKey(next) && !map.get(next).equals(FieldType.WALL)) {
                    int newCost = state.getCost() + 1 + getDirectionCost(state.getDirection(), direction);
                    List<Coordinate> newHistory = new ArrayList<>(state.getHistory());
                    newHistory.add(next);
                    output.add(new State(next, direction, newCost, newHistory));
                }
            }
        }
        return output;
    }

    private int getDirectionCost(Direction currentDirection, Direction newDirection) {
        if (currentDirection.equals(newDirection)) {
            return 0;
        }
        if (currentDirection.isOppositeDirection(newDirection)) {
            throw new IllegalStateException();
        }
        return 1000;
    }

    public int calc1() {
        State starter = new State(start, Direction.RIGHT, 0, new ArrayList<>(Collections.singleton(start)));
        Set<MapKey> visited = new HashSet<>();
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(starter);
        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (current.getCoordinate().equals(end)) {
                return current.getCost();
            }
            visited.add(new MapKey(current.getCoordinate(), current.getDirection()));
            List<State> successors = getSuccessors(current);
            for (State successor : successors) {
                MapKey successorKey = new MapKey(successor.getCoordinate(), successor.getDirection());
                if (!visited.contains(successorKey)) {
                    pq.add(successor);
                }
            }
        }

        throw new IllegalStateException();
    }
}

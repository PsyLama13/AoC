package challenges.year2024.day16.sub;

import challenges.year2024.day16.FieldType;
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
            if (current.coordinate.equals(end)) {
                ends.add(current);
            }
            visited.add(new MapKey(current.coordinate, current.direction));
            List<State> successors = getSuccessors(current);
            for(State successor : successors){
                MapKey successorKey = new MapKey(successor.coordinate, successor.direction);
                if(!visited.contains(successorKey)){
                    pq.add(successor);
                }else{
                }

            }
        }
        List<State> minimums = getMins(ends);
        Set<Coordinate> seats = new HashSet<>();
        for(State min : minimums){
            seats.addAll(min.history);
        }
        //printPath(seats);
        return seats.size();
    }

    private List<State> getMins(List<State> ends) {
        Integer min = ends.stream().map(i->i.cost).min(Integer::compareTo).get();
        return ends.stream().filter(i->i.cost==min).toList();
    }

    private List<State> getSuccessors(State state){
        List<State> output = new ArrayList<>();
        for(Direction direction : Direction.values()){
            if(!state.direction.isOppositeDirection(direction)){
                Coordinate next = state.coordinate.getNeighbourInDirection(direction);
                if(map.containsKey(next) && !map.get(next).equals(FieldType.WALL)){
                    int newCost = state.cost + 1 + getDirectionCost(state.direction, direction);
                    List<Coordinate> newHistory = new ArrayList<>(state.history);
                    newHistory.add(next);
                    output.add(new State(next, direction, newCost, newHistory));
                }
            }
        }
        return output;
    }

    private int getDirectionCost(Direction currentDirection, Direction newDirection) {
        if(currentDirection.equals(newDirection)){
            return 0;
        }
        if(currentDirection.isOppositeDirection(newDirection)){
            throw new IllegalStateException();
        }
        return 1000;
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

    public int calc1() {
        State starter = new State(start, Direction.RIGHT, 0, new ArrayList<>(Collections.singleton(start)));
        Set<MapKey> visited = new HashSet<>();
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(starter);
        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (current.coordinate.equals(end)) {
                return current.cost;
            }
            visited.add(new MapKey(current.coordinate, current.direction));
            List<State> successors = getSuccessors(current);
            for(State successor : successors){
                MapKey successorKey = new MapKey(successor.coordinate, successor.direction);
                if(!visited.contains(successorKey)){
                    pq.add(successor);
                }
            }
        }

        throw new IllegalStateException();
    }
}

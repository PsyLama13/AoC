package challenges.year2024.day18;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class BitMazeSolver {
    private Map<Coordinate, Integer> map = new HashMap<>();
    private Map<Coordinate, FieldType> map1 = new HashMap<>();
    private final Coordinate start = new Coordinate(0, 0);
    private final Coordinate end;

    public BitMazeSolver(List<String> input, int maxX, int maxY, int steps) {
        end = new Coordinate(maxX, maxY);
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                map.put(new Coordinate(x, y), Integer.MAX_VALUE);
                map1.put(new Coordinate(x, y), FieldType.OPEN);
            }
        }
        for (int i = 0; i < input.size(); i++) {
            int x = Integer.parseInt(input.get(i).split(",")[0]);
            int y = Integer.parseInt(input.get(i).split(",")[1]);
            map.put(new Coordinate(x, y), i + 1);
            if(i < steps){
                map1.put(new Coordinate(x, y), FieldType.CORRUPTED);
            }

        }
    }

    public int calc1() {
        PriorityQueue<BitCoordinate> pq = new PriorityQueue<>();
        pq.add(new BitCoordinate(start, 0));
        Set<Coordinate> visited = new HashSet<>();
        int minTime = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            BitCoordinate current = pq.poll();

            if (visited.contains(current.getCoordinate())) {
                continue;
            }
            if (current.getCoordinate().equals(end)) {
                if(current.getStepTime() < minTime){
                    minTime = current.getStepTime();
                }
            }
            visited.add(current.getCoordinate());
            List<BitCoordinate> successors = getSuccessors(current);
            for (BitCoordinate successor : successors) {
                if (!visited.contains(successor.getCoordinate())) {
                    pq.add(successor);
                }
            }
        }

        return minTime;
    }

    private List<BitCoordinate> getSuccessors(BitCoordinate current) {
        List<BitCoordinate> output = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            BitCoordinate temp = new BitCoordinate(current.getCoordinate().getNeighbourInDirection(direction), current.getStepTime() + 1);
            if (isValid(temp)) {
                output.add(temp);
            }
        }
        return output;
    }

    private boolean isValid(BitCoordinate temp) {
        if (!map1.containsKey(temp.getCoordinate()) || map1.get(temp.getCoordinate()).equals(FieldType.CORRUPTED)) {
            return false;
        }
        return true;
    }
}

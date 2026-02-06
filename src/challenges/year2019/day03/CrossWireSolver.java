package challenges.year2019.day03;

import helper.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrossWireSolver {
    Wire wireA;
    Wire wireB;

    public CrossWireSolver(List<String> input) {
        wireA = new Wire(input.getFirst());
        wireB = new Wire(input.getLast());
    }

    public Integer solve1() {
        Set<Coordinate> intersections = getInterSections();
        Integer minDistance = Integer.MAX_VALUE;
        for (Coordinate c : intersections) {
            Integer distance = Coordinate.calculateManhattanDistance(new Coordinate(0, 0), c);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        return minDistance;
    }

    private Set<Coordinate> getInterSections() {
        Set<Coordinate> intersections = new HashSet<>(wireA.getCoordinates());
        intersections.retainAll(wireB.getCoordinates());
        return intersections;
    }
}

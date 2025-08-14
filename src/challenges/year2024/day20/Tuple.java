package challenges.year2024.day20;

import helper.Coordinate;

import java.util.List;

public record Tuple(Coordinate coordinate, int cost, List<Coordinate> history) implements Comparable<Tuple> {
    @Override
    public int compareTo(Tuple o) {
        return Integer.compare(this.cost, o.cost);
    }
}

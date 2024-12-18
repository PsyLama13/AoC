package challenges.year2024.day16;

import helper.Coordinate;
import helper.Direction;

import java.util.List;
import java.util.Objects;

public class MazeKey implements Comparable<MazeKey> {
    Coordinate coordinate;
    Direction direction;
    List<Coordinate> history;
    int cost;

    public MazeKey(Coordinate coordinate, Direction direction, int cost, List<Coordinate> history) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.cost = cost;
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MazeKey mazeKey)) return false;
        return this.coordinate.equals(mazeKey.coordinate) && this.direction.equals(mazeKey.direction) && this.history.equals(mazeKey.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction, cost);
    }

    @Override
    public int compareTo(MazeKey o) {
        return Integer.compare(this.cost, o.cost);
    }

    @Override
    public String toString() {
        return "MazeKey{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                ", cost=" + cost +
                '}';
    }
}

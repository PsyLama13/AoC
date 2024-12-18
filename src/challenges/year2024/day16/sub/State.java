package challenges.year2024.day16.sub;

import helper.Coordinate;
import helper.Direction;

import java.util.List;
import java.util.Objects;

public class State implements Comparable<State> {
    Coordinate coordinate;
    Direction direction;
    int cost;
    List<Coordinate> history;

    public State(Coordinate coordinate, Direction direction, int cost, List<Coordinate> history) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.cost = cost;
        this.history = history;
    }

    @Override
    public int compareTo(State o) {
        return Integer.compare(this.cost, o.cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return coordinate.equals(state.coordinate) && direction == state.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction);
    }
}

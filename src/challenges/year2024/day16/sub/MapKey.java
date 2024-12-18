package challenges.year2024.day16.sub;

import helper.Coordinate;
import helper.Direction;

import java.util.Objects;

public class MapKey {
    Coordinate coordinate;
    Direction direction;


    public MapKey(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapKey that = (MapKey) o;
        return Objects.equals(coordinate, that.coordinate) &&
                direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction);
    }
}

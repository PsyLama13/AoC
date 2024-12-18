package challenges.year2024.day18;

import helper.Coordinate;

import java.util.Objects;

public record BitCoordinate(Coordinate coordinate, int stepTime) implements Comparable<BitCoordinate> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitCoordinate that)) return false;
        return Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return coordinate.hashCode();
    }

    @Override
    public int compareTo(BitCoordinate o) {
        return Integer.compare(this.stepTime, o.stepTime);
    }
}

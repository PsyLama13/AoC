package challenges.year2024.day18;

import helper.Coordinate;

import java.util.Objects;

public class BitCoordinate implements Comparable<BitCoordinate> {
    private Coordinate coordinate;
    private int stepTime;

    public BitCoordinate(Coordinate coordinate, int stepTime) {
        this.coordinate = coordinate;
        this.stepTime = stepTime;
    }

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

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getStepTime() {
        return stepTime;
    }

    @Override
    public int compareTo(BitCoordinate o) {
        return Integer.compare(this.stepTime, o.stepTime);
    }
}

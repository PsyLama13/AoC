package challenges.year2024.day13;

import helper.Coordinate;

public record CoordinateCost(Coordinate coordinate, int cost) implements Comparable<CoordinateCost> {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CoordinateCost other = (CoordinateCost) obj;
        return this.coordinate.equals(other.coordinate);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(CoordinateCost other) {
        return Integer.compare(this.cost, other.cost);
    }
}

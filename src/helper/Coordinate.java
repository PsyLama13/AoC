package helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Coordinate(long x, long y) {
    // top left is 0,0

    public static long getSpanningArea(Coordinate a, Coordinate b) {
        long side1 = Math.abs(a.x - b.x);
        long side2 = Math.abs(a.y - b.y);

        return side1 * side2;
    }

    public static long getSpanningAreaForTiles(Coordinate a, Coordinate b) {
        long side1 = Math.abs(a.x - b.x) + 1;
        long side2 = Math.abs(a.y - b.y) + 1;
        return side1 * side2;
    }

    public static Set<Coordinate> getSpanningCoordinates(Coordinate a, Coordinate b) {
        long minX = Math.min(a.x, b.x);
        long maxX = Math.max(a.x, b.x);
        long minY = Math.min(a.y, b.y);
        long maxY = Math.max(a.y, b.y);

        Set<Coordinate> output = new HashSet<>();
        for (long y = minY; y <= maxY; y++) {
            for (long x = minX; x <= maxX; x++) {
                output.add(new Coordinate(x, y));
            }
        }
        return output;
    }

    public static List<Coordinate> getAllCoordinatesInSpannedRectangle(Coordinate c1, Coordinate c2) {
        long minX = Math.min(c1.x, c2.x);
        long maxX = Math.max(c1.x, c2.x);
        long minY = Math.min(c1.y, c2.y);
        long maxY = Math.max(c1.y, c2.y);

        List<Coordinate> output = new ArrayList<>();
        for (long y = minY; y <= maxY; y++) {
            for (long x = minX; x <= maxX; x++) {
                output.add(new Coordinate(x, y));
            }
        }
        return output;
    }

    public Coordinate up() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate down() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate left() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate upRight() {
        return new Coordinate(x + 1, y - 1);
    }

    public Coordinate upLeft() {
        return new Coordinate(x - 1, y - 1);
    }

    public Coordinate downRight() {
        return new Coordinate(x + 1, y + 1);
    }

    public Coordinate downLeft() {
        return new Coordinate(x - 1, y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        return x == ((Coordinate) o).x() && y == ((Coordinate) o).y();
    }

    public boolean isNeighbouringTo(Coordinate x) {
        if (this.equals(x)) {
            return false;
        }
        long dx = Math.abs(this.x() - x.x());
        long dy = Math.abs(this.y() - x.y());
        return dx <= 1 && dy <= 1;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public Coordinate plus(Coordinate o) {
        return new Coordinate(x + o.x(), y + o.y());
    }

    public Coordinate getNeighbourInDirection(Direction direction) {
        return switch (direction) {
            case UP -> this.up();
            case DOWN -> this.down();
            case LEFT -> this.left();
            case RIGHT -> this.right();
        };
    }

    public List<Coordinate> getFourNeighbours() {
        return List.of(this.up(), this.down(), this.right(), this.left());
    }

    public List<Coordinate> getEightNeighbours() {
        return List.of(this.up(), this.down(), this.left(), this.right(), this.upLeft(), this.upRight(), this.downLeft(), this.downRight());
    }

    public List<Coordinate> getNeighboursInDistance(int distance) {
        List<Coordinate> neighbours = new ArrayList<>();
        for (int i = 0; i <= distance; i++) {
            neighbours.add(new Coordinate(x + i, y - distance + i));
            neighbours.add(new Coordinate(x + distance - i, y + i));
            neighbours.add(new Coordinate(x - i, y + distance - i));
            neighbours.add(new Coordinate(x - distance + i, y - i));
        }
        return neighbours;
    }
}

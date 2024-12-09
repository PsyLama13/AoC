package helper;

import java.util.ArrayList;
import java.util.List;

public record Coordinate(int x, int y) {
    // top left is 0,0

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

    public List<Coordinate> getAllNeighbours() {
        return List.of(this.up(), this.down(), this.left(), this.right());
    }

    public List<Coordinate> getAllNeightboursWithDiagonals() {
        List<Coordinate> output = new ArrayList<>(getAllNeighbours());
        output.addAll(List.of(this.upLeft(), this.upRight(), this.downLeft(), this.downRight()));
        return output;
    }

    public List<Coordinate> getAllDiagonals(){
        return List.of(this.upLeft(), this.upRight(), this.downLeft(), this.downRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return 31 * x * y;
    }

    public boolean isNeighbouringTo(Coordinate x) {
        if (this.equals(x)) {
            return false;
        }
        int dx = Math.abs(this.x() - x.x());
        int dy = Math.abs(this.y() - x.y());
        return dx <= 1 && dy <= 1;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

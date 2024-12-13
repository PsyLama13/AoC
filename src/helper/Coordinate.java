package helper;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        return x == ((Coordinate) o).x() && y == ((Coordinate) o).y();
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

    public Coordinate plus(Coordinate o) {
        return new Coordinate(x + o.x(), y + o.y());
    }

}

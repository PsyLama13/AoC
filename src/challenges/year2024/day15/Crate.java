package challenges.year2024.day15;

import helper.Coordinate;

import java.util.Objects;

public class Crate {
    private Coordinate left;
    private Coordinate right;

    public Crate(Coordinate left, Coordinate right) {
        this.left = left;
        this.right = right;
    }

    public void setLeft(Coordinate left) {
        this.left = left;
    }

    public void setRight(Coordinate right) {
        this.right = right;
    }

    public Coordinate getLeft() {
        return left;
    }

    public Coordinate getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crate crate)) return false;
        return left.equals(crate.left) && right.equals(crate.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

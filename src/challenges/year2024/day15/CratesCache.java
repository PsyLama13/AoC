package challenges.year2024.day15;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class CratesCache {
    private List<Crate> crateList = new ArrayList<>();
    private Set<Coordinate> coordinates = new HashSet<>();

    public void addCrate(Coordinate c1, Coordinate c2) {
        Crate crate = new Crate(c1, c2);
        crateList.add(crate);
        coordinates.addAll(List.of(c1, c2));
    }

    public List<Crate> getAllCrates() {
        return crateList;
    }

    public Direction isCrate(Coordinate c) {
        Optional<Crate> left = crateList.stream().filter(crate -> crate.left.equals(c)).findFirst();
        Optional<Crate> right = crateList.stream().filter(crate -> crate.right.equals(c)).findFirst();

        if (left.isPresent()) {
            return Direction.LEFT;
        }

        if (right.isPresent()) {
            return Direction.RIGHT;
        }
        return null;
    }

    public Set<Crate> getCratesToMove(Direction direction, Coordinate roboLocation) {
        Set<Crate> crates = new HashSet<>();
        Coordinate next = roboLocation.getNeighbourInDirection(direction);
        getCratesToMoveRecursively(direction, next, crates);
        return crates;
    }

    private void getCratesToMoveRecursively(Direction direction, Coordinate coordinate, Set<Crate> crates) {
        Optional<Crate> crate = getCrate(coordinate);
        if (crate.isPresent()) {
            crates.add(crate.get());
            switch (direction) {
                case UP, DOWN -> {
                    Coordinate l = crate.get().left.getNeighbourInDirection(direction);
                    Coordinate r = crate.get().right.getNeighbourInDirection(direction);
                    getCratesToMoveRecursively(direction, l, crates);
                    getCratesToMoveRecursively(direction, r, crates);
                }
                case LEFT -> {
                    Coordinate c = crate.get().left.left();
                    getCratesToMoveRecursively(direction, c, crates);
                }
                case RIGHT -> {
                    Coordinate c = crate.get().right.right();
                    getCratesToMoveRecursively(direction, c, crates);
                }
            }
        }
    }

    private Optional<Crate> getCrate(Coordinate coordinate) {
        return crateList.stream().filter(c -> c.right.equals(coordinate) || c.left.equals(coordinate)).findFirst();
    }

    public boolean isFreeToMove(Set<Crate> cratesToMove, Direction direction, Map<Coordinate, FieldType> map) {
        for (Crate crate : cratesToMove) {
            switch (direction) {
                case UP, DOWN -> {
                    Coordinate c1 = crate.left.getNeighbourInDirection(direction);
                    Coordinate c2 = crate.right.getNeighbourInDirection(direction);
                    if (map.get(c1).equals(FieldType.WALL) || map.get(c2).equals(FieldType.WALL)) {
                        return false;
                    }
                }
                case LEFT -> {
                    Coordinate c = crate.left.left();
                    if (map.get(c).equals(FieldType.WALL)) {
                        return false;
                    }
                }
                case RIGHT -> {
                    Coordinate c = crate.right.right();
                    if (map.get(c).equals(FieldType.WALL)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveCratesInDirection(Set<Crate> cratesToMove, Direction direction) {
        for (Crate crate : cratesToMove) {
            coordinates.removeAll(List.of(crate.left, crate.right));
            int crateIndex = crateList.indexOf(crate);
            if (crateIndex == -1) {
                throw new IllegalStateException();
            }
            crateList.get(crateIndex).left = crate.left.getNeighbourInDirection(direction);
            crateList.get(crateIndex).right = crate.right.getNeighbourInDirection(direction);
            coordinates.add(crate.left.getNeighbourInDirection(direction));
            coordinates.add(crate.right.getNeighbourInDirection(direction));
        }
    }
}

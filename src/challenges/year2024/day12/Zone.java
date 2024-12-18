package challenges.year2024.day12;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class Zone {
    private final Set<Coordinate> coordinates = new HashSet<>();
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public Zone(Coordinate startingPoint, List<Coordinate> remainingCoordinates) {
        fillRecursively(startingPoint, remainingCoordinates);
        initMinMaxValues();
    }

    private void initMinMaxValues() {
        minY = Math.toIntExact(coordinates.stream().min(Comparator.comparingLong(Coordinate::y)).orElseThrow().y());
        maxY = Math.toIntExact(coordinates.stream().max(Comparator.comparingLong(Coordinate::y)).orElseThrow().y());
        minX = (int) coordinates.stream().min(Comparator.comparingLong(Coordinate::x)).orElseThrow().x();
        maxX = (int) coordinates.stream().max(Comparator.comparingLong(Coordinate::x)).orElseThrow().x();
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public int getFencingPricePart1() {
        return getPerimeter() * getRegion();
    }

    public int getFencingPricePart2() {
        return getRegion() * getLines();
    }

    private void fillRecursively(Coordinate current, List<Coordinate> remainingCoordinates) {

        if (coordinates.contains(current) || !remainingCoordinates.contains(current)) {
            return;
        }

        coordinates.add(current);

        Coordinate up = current.up();
        Coordinate down = current.down();
        Coordinate left = current.left();
        Coordinate right = current.right();

        fillRecursively(up, remainingCoordinates);
        fillRecursively(down, remainingCoordinates);
        fillRecursively(left, remainingCoordinates);
        fillRecursively(right, remainingCoordinates);
    }

    private int getRegion() {
        return coordinates.size();
    }

    private int getLines() {
        int counter = 0;
        for (Direction direction : Direction.values()) {
            counter += getLineAmount(direction);
        }
        return counter;
    }

    private int getLineAmount(Direction direction) {
        int counter = 0;
        Coordinate current = getStartCoordinate(direction);
        boolean isInside = false;
        while (true) {
            if (coordinates.contains(current)) {
                Coordinate neighbour = getBorderCheckCoordinate(current, direction);
                if (!coordinates.contains(neighbour) && !isInside) {
                    isInside = true;
                    counter++;
                } else if (coordinates.contains(neighbour)) {
                    isInside = false;
                }
            } else {
                isInside = false;
            }

            current = getNextCoordinate(current, direction);
            if (hasReachedEnd(current, direction)) {
                break;
            }
            if (exceedsLine(current, direction)) {
                current = getFirstOnNextLine(current, direction);
            }
        }
        return counter;
    }

    private Coordinate getFirstOnNextLine(Coordinate current, Direction direction) {
        return switch (direction) {
            case UP -> new Coordinate(minX, current.y() + 1);
            case DOWN -> new Coordinate(minX, current.y() - 1);
            case LEFT -> new Coordinate(current.x() + 1, minY);
            case RIGHT -> new Coordinate(current.x() - 1, minY);
        };
    }

    private boolean exceedsLine(Coordinate current, Direction direction) {
        return switch (direction) {
            case UP, DOWN -> current.x() > maxX;
            case LEFT, RIGHT -> current.y() > maxY;
        };
    }

    private Coordinate getNextCoordinate(Coordinate current, Direction direction) {
        return switch (direction) {
            case UP, DOWN -> current.right();
            case LEFT, RIGHT -> current.down();
        };
    }

    private Coordinate getBorderCheckCoordinate(Coordinate current, Direction direction) {
        return switch (direction) {
            case UP -> current.up();
            case DOWN -> current.down();
            case LEFT -> current.left();
            case RIGHT -> current.right();
        };
    }

    private boolean hasReachedEnd(Coordinate current, Direction direction) {
        Coordinate end = getEndCoordinate(direction);

        return switch (direction) {
            case UP, LEFT -> current.x() >= end.x() && current.y() >= end.y();
            case DOWN -> current.x() >= end.x() && current.y() <= end.y();
            case RIGHT -> current.x() <= end.x() && current.y() <= end.y();
        };
    }

    private Coordinate getEndCoordinate(Direction direction) {
        return switch (direction) {
            case UP, LEFT -> new Coordinate(maxX, maxY);
            case DOWN -> new Coordinate(maxX, minY);
            case RIGHT -> new Coordinate(minX, maxY);
        };
    }

    private Coordinate getStartCoordinate(Direction direction) {
        return switch (direction) {
            case UP, LEFT -> new Coordinate(minX, minY);
            case DOWN -> new Coordinate(minX, maxY);
            case RIGHT -> new Coordinate(maxX, minY);
        };
    }

    private int getRightLines(int minX, int maxX, int minY, int maxY) {
        int counter = 0;
        for (int x = maxX; x >= minX; x--) {
            boolean isInside = false;
            for (int y = minY; y <= maxY; y++) {
                Coordinate c = new Coordinate(x, y);
                if (coordinates.contains(c)) {
                    if (!coordinates.contains(c.right()) && !isInside) {
                        isInside = true;
                        counter++;
                        continue;
                    }
                    if (coordinates.contains(c.right())) {
                        isInside = false;
                    }
                } else {
                    isInside = false;
                }
            }
        }
        return counter;
    }

    private int getLeftLines(int minX, int maxX, int minY, int maxY) {
        int counter = 0;
        for (int x = minX; x <= maxX; x++) {
            boolean isInside = false;
            for (int y = minY; y <= maxY; y++) {
                Coordinate c = new Coordinate(x, y);
                if (coordinates.contains(c)) {
                    if (!coordinates.contains(c.left()) && !isInside) {
                        isInside = true;
                        counter++;
                        continue;
                    }
                    if (coordinates.contains(c.left())) {
                        isInside = false;
                    }
                } else {
                    isInside = false;
                }
            }
        }
        return counter;
    }

    private int getBotLines(int minX, int maxX, int minY, int maxY) {
        int counter = 0;

        for (int y = maxY; y >= minY; y--) {
            boolean isInside = false;
            for (int x = minX; x <= maxX; x++) {
                Coordinate c = new Coordinate(x, y);
                if (coordinates.contains(c)) {
                    if (!coordinates.contains(c.down()) && !isInside) {
                        isInside = true;
                        counter++;
                        continue;
                    }
                    if (coordinates.contains(c.down())) {
                        isInside = false;
                    }
                } else {
                    isInside = false;
                }
            }
        }
        return counter;
    }

    private int getTopLines(int minX, int maxX, int minY, int maxY) {
        int counter = 0;

        for (int y = minY; y <= maxY; y++) {
            boolean isInside = false;
            for (int x = minX; x <= maxX; x++) {
                Coordinate c = new Coordinate(x, y);
                if (coordinates.contains(c)) {
                    if (!coordinates.contains(c.up()) && !isInside) {
                        isInside = true;
                        counter++;
                        continue;
                    }
                    if (coordinates.contains(c.up())) {
                        isInside = false;
                    }
                } else {
                    isInside = false;
                }
            }
        }
        return counter;
    }

    private int getPerimeter() {
        Set<Coordinate> visited = new HashSet<>();
        int totalPerimeter = 0;
        for (Coordinate coordinate : coordinates) {
            if (!visited.contains(coordinate)) {
                totalPerimeter += processBoundaryPerimeter(coordinate, visited);
            }
        }
        return totalPerimeter;
    }

    private int processBoundaryPerimeter(Coordinate start, Set<Coordinate> visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        int perimeter = 0;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (Coordinate neighbour : Arrays.asList(current.up(), current.down(), current.left(), current.right())) {
                if (!coordinates.contains(neighbour)) {
                    perimeter++;
                } else if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return perimeter;
    }
}

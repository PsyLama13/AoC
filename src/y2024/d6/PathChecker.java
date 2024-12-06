package y2024.d6;

import helper.Coordinate;
import helper.Direction;

import java.util.List;

public class PathChecker {
    Guard guard;
    Grid grid;

    public PathChecker(List<String> input) {
        int maxX = input.get(0).length();
        int maxY = input.size();
        grid = new Grid(maxX, maxY);
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                String letter = String.valueOf(input.get(y).charAt(x));
                TyleType tileType = TyleType.parseTyleType(letter);
                if (tileType == null) {
                    // handle guard;
                    grid.addField(x, y, TyleType.OPEN);
                    Direction direction = getGuardDirection(letter);
                    guard = new Guard(new Coordinate(x, y), direction);
                } else {
                    grid.addField(x, y, tileType);
                }
            }
        }
        //grid.print(); // only debugging
        guard.run(grid);
    }

    private Direction getGuardDirection(String letter) {
        return switch (letter) {
            case "<" -> Direction.LEFT;
            case ">" -> Direction.RIGHT;
            case "^" -> Direction.UP;
            case "v" -> Direction.DOWN;
            default -> throw new IllegalStateException("Unexpected value: " + letter);
        };
    }

    public int calc1() {
        return guard.visited.size();
    }

    public int calc2() {

        return grid.calculateObstructionPoints(guard);
    }
}

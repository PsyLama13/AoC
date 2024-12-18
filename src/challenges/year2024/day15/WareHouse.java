package challenges.year2024.day15;

import helper.Coordinate;
import helper.Direction;

import java.util.*;

public class WareHouse {
    private Map<Coordinate, FieldType> map = new HashMap<>();
    private final CratesCache cratesCache = new CratesCache();
    private List<Direction> moves = new ArrayList<>();
    private Coordinate robotLocation;
    private final int maxX;
    private final int maxY;

    public WareHouse(List<String> input) {
        List<String> mapStrings = new ArrayList<>();
        List<String> commandStrings = new ArrayList<>();

        boolean isMapString = true;
        for (String s : input) {
            if (s.isEmpty()) {
                isMapString = false;
                continue;
            }
            if (isMapString) {
                mapStrings.add(s);
            } else {
                commandStrings.add(s);
            }
        }
        maxX = mapStrings.get(0).length() * 2;
        maxY = mapStrings.size();

        map = parseMapStrings(mapStrings);
        moves = parseMoves(commandStrings);
        printMap();
    }

    private List<Direction> parseMoves(List<String> commandStrings) {
        List<Direction> directions = new ArrayList<>();
        for (String s : commandStrings) {
            for (String commandString : s.split("")) {
                directions.add(parseDirection(commandString));
            }
        }
        return directions;
    }

    private Direction parseDirection(String commandString) {
        return switch (commandString) {
            case "<" -> Direction.LEFT;
            case ">" -> Direction.RIGHT;
            case "^" -> Direction.UP;
            case "v" -> Direction.DOWN;
            default -> throw new IllegalStateException("Unexpected value: " + commandString);
        };
    }

    private Map<Coordinate, FieldType> parseMapStrings(List<String> mapStrings) {
        Map<Coordinate, FieldType> output = new HashMap<>();
        for (int y = 0; y < mapStrings.size(); y++) {
            for (int x = 0; x < mapStrings.get(0).length() * 2; x = x + 2) {
                Coordinate c1 = new Coordinate(x, y);
                Coordinate c2 = new Coordinate(x + 1, y);
                Character s = mapStrings.get(y).charAt(x / 2);
                FieldType type = getFieldType(s);
                if (type.equals(FieldType.ROBOT)) {
                    robotLocation = c1;
                    type = FieldType.OPEN;
                }
                if (type.equals(FieldType.CRATE_LEFT)) {
                    cratesCache.addCrate(c1, c2);
                    type = FieldType.OPEN;
                }
                output.put(c1, type);
                output.put(c2, type);
            }
        }
        return output;
    }

    private FieldType getFieldType(Character s) {
        return switch (s) {
            case '#' -> FieldType.WALL;
            case '.' -> FieldType.OPEN;
            case 'O' -> FieldType.CRATE_LEFT;
            case '@' -> FieldType.ROBOT;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    void printMap() {
        for (int y = 0; y < maxY; y++) {
            StringBuilder s = new StringBuilder();
            for (int x = 0; x < maxX; x++) {
                Coordinate c = new Coordinate(x, y);
                handleCoordinate(c, s);
            }
            System.out.println(s);
        }
    }

    private void handleCoordinate(Coordinate c, StringBuilder s) {
        if (c.equals(robotLocation)) {
            s.append("@");
            return;
        }
        Direction d = cratesCache.isCrate(c);
        if (d != null) {
            if (d.equals(Direction.LEFT)) {
                s.append("[");
            }
            if (d.equals(Direction.RIGHT)) {
                s.append("]");
            }
        } else {
            FieldType type = map.get(c);
            switch (type) {
                case WALL -> s.append("#");
                case OPEN -> s.append(".");
            }
        }
    }

    public void runCommands() {
        for (Direction direction : moves) {
            runCommand(direction);
        }
    }

    private void runCommand(Direction direction) {
        Coordinate next = robotLocation.getNeighbourInDirection(direction);
        if (!map.get(next).equals(FieldType.WALL)) {
            if (cratesCache.isCrate(next) != null) {
                // handle crates
                handleCrates(direction);
            } else {
                // else open field, we can just walk
                robotLocation = next;
            }
        }
    }

    private void handleCrates(Direction direction) {
        Set<Crate> cratesToMove = cratesCache.getCratesToMove(direction, robotLocation);
        if (cratesCache.isFreeToMove(cratesToMove, direction, map)) {
            cratesCache.moveCratesInDirection(cratesToMove, direction);
            robotLocation = robotLocation.getNeighbourInDirection(direction);
        }
    }

    public int calc2() {
        int counter = 0;
        for (Crate crate : cratesCache.getAllCrates()) {
            counter += (int) (100 * crate.getLeft().y() + crate.getLeft().x());
        }
        return counter;
    }
}

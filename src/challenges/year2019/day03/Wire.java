package challenges.year2019.day03;

import helper.Coordinate;
import helper.Direction;

import java.util.HashSet;
import java.util.Set;

public class Wire {
    private Set<Coordinate> coordinates = new HashSet<>();

    public Wire(String commandLine) {
        String[] commands = commandLine.split(",");
        Coordinate current = new Coordinate(0, 0);
        for (String command : commands) {
            String directionString = command.substring(0, 1);
            String amountString = command.substring(1);
            Direction direction = Direction.getDirectionFromString(directionString);
            Integer amount = Integer.parseInt(amountString);

            Set<Coordinate> stepSet = new HashSet<>();
            current = walkSteps(current, direction, amount, stepSet);
            coordinates.addAll(stepSet);
        }
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    private Coordinate walkSteps(Coordinate current, Direction direction, Integer amount, Set<Coordinate> stepSet) {
        for (int i = 0; i < amount; i++) {
            current = current.getNeighbourInDirection(direction);
            stepSet.add(new Coordinate(current.x(), current.y()));
        }

        return current;
    }
}

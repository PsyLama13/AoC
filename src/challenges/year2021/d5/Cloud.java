package challenges.year2021.d5;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Cloud {
    Coordinate startPoint;
    Coordinate endPoint;

    public Cloud(String input) {
        List<String> list = List.of(input.split(" -> "));
        int startX = Integer.parseInt(list.get(0).split(",")[0]);
        int startY = Integer.parseInt(list.get(0).split(",")[1]);
        int endX = Integer.parseInt(list.get(1).split(",")[0]);
        int endY = Integer.parseInt(list.get(1).split(",")[1]);

        startPoint = new Coordinate(startX, startY);
        endPoint = new Coordinate(endX, endY);
    }

    public List<Coordinate> getCloudLine() {
        if (isDiagonal()) {
            return new ArrayList<>();
        }

        Direction direction = getDirection();
        return getLineAccordingToDirection(direction);

    }

    private List<Coordinate> getLineAccordingToDirection(Direction direction) {
        List<Coordinate> output = new ArrayList<>();
        if (direction == null) {
            return output;
        }
        int xDiff = (int) (endPoint.x() - startPoint.x());
        int yDiff = (int) (endPoint.y() - startPoint.y());
        Coordinate temp = startPoint;
        output.add(temp);
        switch (direction) {

            case UP -> {
                for (int i = 0; i < -yDiff; i++) {
                    temp = temp.up();
                    output.add(temp);
                }
            }
            case DOWN -> {
                for (int i = 0; i < yDiff; i++) {
                    temp = temp.down();
                    output.add(temp);
                }
            }
            case LEFT -> {
                for (int i = 0; i < -xDiff; i++) {
                    temp = temp.left();
                    output.add(temp);
                }
            }
            case RIGHT -> {
                for (int i = 0; i < xDiff; i++) {
                    temp = temp.right();
                    output.add(temp);
                }
            }
        }
        return output;
    }

    private Direction getDirection() {
        if (startPoint.x() == endPoint.x()) {
            if (startPoint.y() == endPoint.y()) {
                return null;
            }
            if (startPoint.y() > endPoint.y()) {
                return Direction.UP;
            } else {
                return Direction.DOWN;
            }
        } else if (startPoint.y() == endPoint.y()) {
            if (startPoint.x() > endPoint.x()) {
                return Direction.LEFT;
            } else {
                return Direction.RIGHT;
            }
        }

        return null;
    }

    public boolean isDiagonal() {
        return !(startPoint.x() == endPoint.x() || startPoint.y() == endPoint.y());
    }
}

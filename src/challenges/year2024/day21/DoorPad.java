package challenges.year2024.day21;

import helper.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class DoorPad {
    private static final Map<String, Coordinate> map = initMap();
    private static final Coordinate start = new Coordinate(2, 3);

    private static Map<String, Coordinate> initMap() {
        Map<String, Coordinate> output = new HashMap<>();
        output.put("7", new Coordinate(0, 0));
        output.put("8", new Coordinate(1, 0));
        output.put("9", new Coordinate(2, 0));
        output.put("4", new Coordinate(0, 1));
        output.put("5", new Coordinate(1, 1));
        output.put("6", new Coordinate(2, 1));
        output.put("1", new Coordinate(0, 2));
        output.put("2", new Coordinate(1, 2));
        output.put("3", new Coordinate(2, 2));
        output.put("0", new Coordinate(1, 3));
        output.put("A", new Coordinate(2, 3));
        return output;
    }

    private DoorPad() {
        throw new IllegalStateException("Utility Class");
    }

    private static void getNextSequence(Coordinate current, StringBuilder output, String s) {
        Coordinate next = map.get(s);

        long xOffset = next.x() - current.x();
        long yOffset = next.y() - current.y();

        if (xOffset < 0 && yOffset < 0) {
            output.append(getYOffsetCode(yOffset));
            output.append(getXOffsetCode(xOffset));
        } else {
            output.append(getXOffsetCode(xOffset));
            output.append(getYOffsetCode(yOffset));
        }
    }

    static String getXOffsetCode(long xOffset) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < Math.abs(xOffset); i++) {
            if (xOffset > 0) {
                code.append(">");
            } else {
                code.append("<");
            }
        }
        return code.toString();
    }

    static String getYOffsetCode(long yOffset) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < Math.abs(yOffset); i++) {
            if (yOffset > 0) {
                code.append("v");
            } else {
                code.append("^");
            }
        }
        return code.toString();
    }
}
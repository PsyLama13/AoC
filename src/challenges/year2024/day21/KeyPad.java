package challenges.year2024.day21;

import helper.Coordinate;

import java.util.HashMap;
import java.util.Map;

import static challenges.year2024.day21.DoorPad.getXOffsetCode;
import static challenges.year2024.day21.DoorPad.getYOffsetCode;

public class KeyPad {
    private KeyPad() {
        throw new IllegalStateException("Utility Class");
    }

    private static final Map<String, Coordinate> map = initMap();
    private static final Coordinate start = new Coordinate(2, 0);

    private static Map<String, Coordinate> initMap() {
        Map<String, Coordinate> output = new HashMap<>();
        output.put("^", new Coordinate(1, 0));
        output.put("A", new Coordinate(2, 0));
        output.put("<", new Coordinate(0, 1));
        output.put("v", new Coordinate(1, 1));
        output.put(">", new Coordinate(2, 1));
        return output;
    }

    public static String encode(String code) {
        Coordinate current = start;
        StringBuilder output = new StringBuilder();
        for (String s : code.split("")) {
            getNextSequence(current, output, s);
            output.append("A");
            current = map.get(s);
        }
        return output.toString();
    }

    private static void getNextSequence(Coordinate current, StringBuilder output, String s) {
        Coordinate next = map.get(s);

        long xOffset = next.x() - current.x();
        long yOffset = next.y() - current.y();

        if (current.y() > next.y()) {
            output.append(getXOffsetCode(xOffset));
            output.append(getYOffsetCode(yOffset));
        } else {
            output.append(getYOffsetCode(yOffset));
            output.append(getXOffsetCode(xOffset));
        }
    }
}

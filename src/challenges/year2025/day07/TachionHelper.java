package challenges.year2025.day07;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class TachionHelper {
    private Coordinate start;
    private final Splitters splitters;
    private final int maxX;
    private final int maxY;

    public TachionHelper(List<String> input) {
        maxX = input.getFirst().length();
        maxY = input.size();
        List<Coordinate> splitterCoordinates = new ArrayList<>();
        for (int y = 0; y < input.size(); y++) {
            List<String> s = List.of(input.get(y).split(""));
            for (int x = 0; x < s.size(); x++) {
                String val = s.get(x);
                Coordinate coordinate = new Coordinate(x, y);
                switch (val) {
                    case "S" -> start = coordinate;
                    case "^" -> splitterCoordinates.add(coordinate);
                    case "." -> { // . is an empty field. Nothing happens here!
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + val);
                }
            }
        }
        splitters = new Splitters(splitterCoordinates);
    }

    public long solve() {
        TachionBeams tachionBeams = new TachionBeams(start, maxX, maxY);

        for (int y = 0; y < maxY; y++) {
            List<Long> coords = splitters.getAllSplittersForDepth((long) y);
            if (coords.isEmpty()) {
                continue;
            }
            for (Long xVal : coords) {
                if (tachionBeams.contains(xVal)) {
                    tachionBeams.handleRaySplit(xVal);
                }
            }
        }
        return tachionBeams.getSplitCount();
    }

    public long solve2() {
        TachionBeams tachionBeams = new TachionBeams(start, maxX, maxY);
        return tachionBeams.getTimelineCount(splitters);
    }
}
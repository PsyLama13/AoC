package challenges.year2025.day07;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Splitters {
    private HashMap<Long, List<Long>> splitterMap = new HashMap<>();

    public Splitters(List<Coordinate> splitterCoordinates) {
        for (Coordinate c : splitterCoordinates) {
            splitterMap.computeIfAbsent(c.y(), k -> new ArrayList<>()).add(c.x());
        }
    }

    public List<Long> getAllSplittersForDepth(Long depth) {
        if (splitterMap.containsKey(depth)) {
            return splitterMap.get(depth);
        }
        return new ArrayList<>();
    }

    public boolean containsSplitter(long y, long xCoordinateOfRay) {
        if (splitterMap.containsKey(y)) {
            return splitterMap.get(y).contains(xCoordinateOfRay);
        }
        return false;
    }
}
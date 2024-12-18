package challenges.year2024.day8;

import helper.Coordinate;

import java.util.*;

public class AntennaHelper {

    private final Map<String, List<Coordinate>> map = new HashMap<>();
    private final int maxX;
    private final int maxY;

    public AntennaHelper(List<String> input) {
        maxX = input.get(0).length();
        maxY = input.size();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                String str = String.valueOf(input.get(y).charAt(x));
                if (!str.equals(".")) {
                    map.computeIfAbsent(str, k -> new ArrayList<>()).add(new Coordinate(x, y));
                }
            }
        }
    }

    public int calc1() {
        Set<Coordinate> antiPoints = new HashSet<>();
        for (Map.Entry<String, List<Coordinate>> entry : map.entrySet()) {
            List<NodePair> nodePairs = calculateNodePairs(entry.getValue());
            for (NodePair nodePair : nodePairs) {
                antiPoints.addAll(nodePair.getAntiNodes());
            }
        }
        return antiPoints.size();
    }

    private List<NodePair> calculateNodePairs(List<Coordinate> set) {
        List<NodePair> output = new ArrayList<>();

        for (int i = 0; i < set.size(); i++) {
            Coordinate first = set.get(i);
            for (int j = i + 1; j < set.size(); j++) {
                Coordinate second = set.get(j);
                output.add(new NodePair(first, second, maxX, maxY));
            }
        }
        return output;
    }

    public int calc2() {
        Set<Coordinate> antiPoints = new HashSet<>();
        for (Map.Entry<String, List<Coordinate>> entry : map.entrySet()) {
            List<NodePair> nodePairs = calculateNodePairs(entry.getValue());
            for (NodePair nodePair : nodePairs) {
                antiPoints.addAll(nodePair.getFullAntiNodes());
            }
        }
        return antiPoints.size();
    }
}
package y2024.d8;

import helper.Coordinate;

import java.util.*;

public class AntennaHelper {

    Map<String, List<Coordinate>> map = new HashMap<>();
    int maxX;
    int maxY;

    public AntennaHelper(List<String> input) {
        maxX = input.get(0).length();
        maxY = input.size();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                String str = String.valueOf(input.get(y).charAt(x));
                if (!str.equals(".")) {
                    final int fx = x;
                    final int fy = y;
                    map.computeIfAbsent(str, k -> new ArrayList<>()).add(new Coordinate(fx, fy));
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

        for(int i  = 0; i < set.size(); i++){
            Coordinate first = set.get(i);
            for(int j = i+1; j < set.size(); j++){
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

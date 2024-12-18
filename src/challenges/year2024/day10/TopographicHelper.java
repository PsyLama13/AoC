package challenges.year2024.day10;

import helper.Coordinate;

import java.util.*;

public class TopographicHelper {
    private final Map<Coordinate, Integer> coordinateToHeightMap = new HashMap<>();
    private final Set<Coordinate> starts = new HashSet<>();
    private final List<TrailHead> trailHeads = new ArrayList<>();

    public TopographicHelper(List<String> input) {
        initMap(input);
        initTrailHeads();
    }

    private void initTrailHeads() {
        for (Coordinate start : starts) {
            TrailHead trailHead = new TrailHead(start, coordinateToHeightMap);
            trailHeads.add(trailHead);
        }
    }

    private void initMap(List<String> input) {
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                Character c = input.get(y).charAt(x);
                if (!c.equals('.')) {
                    int num = Integer.parseInt(String.valueOf(c));
                    if (num == 0) {
                        starts.add(new Coordinate(x, y));
                    }
                    coordinateToHeightMap.put(new Coordinate(x, y), num);
                }
            }
        }
    }

    public Integer calc1() {
        int counter = 0;
        for (TrailHead trailHead : trailHeads) {
            counter += trailHead.getScore();
        }
        return counter;
    }

    public Integer calc2(){
        int counter = 0;
        for(TrailHead trailHead : trailHeads){
            counter += trailHead.getRating();
        }
        return counter;
    }
}

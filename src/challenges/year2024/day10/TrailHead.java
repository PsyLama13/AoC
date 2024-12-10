package challenges.year2024.day10;

import helper.Coordinate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrailHead {
    private final Map<Coordinate, Integer> coordinateToHeightMap;
    private final Coordinate start;
    private Integer score;
    private Integer rating;

    public TrailHead(Coordinate start, Map<Coordinate, Integer> coordinateToHeightMap) {
        this.coordinateToHeightMap = coordinateToHeightMap;
        this.start = start;
        this.score = calcScore();
        this.rating = calcRating();
    }

    public int getScore() {
        return score;
    }

    public int getRating() {
        return rating;
    }

    private int calcRating() {
        return dfsRating(start, 0);
    }

    private int calcScore() {
        return dfsScore(new HashSet<>(), start, 0);
    }

    private int dfsRating(Coordinate current, int currentHeight) {
        if (!coordinateToHeightMap.containsKey(current) || coordinateToHeightMap.get(current) != currentHeight){
            return 0;
        }

        if(coordinateToHeightMap.get(current) == 9){
            return 1;
        }

        int paths = 0;
        paths += dfsRating(current.up(), currentHeight + 1);
        paths += dfsRating(current.down(), currentHeight + 1);
        paths += dfsRating(current.left(), currentHeight + 1);
        paths += dfsRating(current.right(), currentHeight + 1);

        return paths;
    }

    private int dfsScore(Set<Coordinate> visitedEnds, Coordinate current, int currentHeight) {
        if (!coordinateToHeightMap.containsKey(current) || coordinateToHeightMap.get(current) != currentHeight) {
            return 0;
        }

        if (coordinateToHeightMap.get(current) == 9 && !visitedEnds.contains(current)) {
            visitedEnds.add(current);
            return 1;
        }

        int paths = 0;
        paths += dfsScore(visitedEnds, current.up(), currentHeight + 1);
        paths += dfsScore(visitedEnds, current.down(), currentHeight + 1);
        paths += dfsScore(visitedEnds, current.left(), currentHeight + 1);
        paths += dfsScore(visitedEnds, current.right(), currentHeight + 1);

        return paths;
    }
}

package challenges.year2025.day09;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GridList {
    List<Coordinate> redTiles = new ArrayList<>();

    public GridList(List<String> input) {
        for (String s : input) {
            String[] split = s.split(",");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            redTiles.add(new Coordinate(a, b));
        }
    }

    public long getBiggestSpanningArea() {
        long currentBiggestArea = 0;
        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                Coordinate c1 = redTiles.get(i);
                Coordinate c2 = redTiles.get(j);
                long area = Coordinate.getSpanningAreaForTiles(c1, c2);
                if (area > currentBiggestArea) {
                    currentBiggestArea = area;
                }
            }
        }
        return currentBiggestArea;
    }

    public long getBiggestSpanningAreaInsideArea() {
        Set<Line> lineSet = Line.lineSetFromCoordinates(redTiles);
        long biggestArea = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                Coordinate c1 = redTiles.get(i);
                Coordinate c2 = redTiles.get(j);

                boolean intersectsEdge = lineSet.stream().anyMatch(l -> l.intersectsRectangle(c1, c2));
                if (!intersectsEdge) {
                    long area = Coordinate.getSpanningAreaForTiles(c1, c2);
                    if (area > biggestArea) {
                        biggestArea = area;
                    }
                }
            }
        }
        return biggestArea;
    }
}
package challenges.year2024.day14;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class RoboMapHelper {

    List<Robo> robos = new ArrayList<>();
    int steps;
    int maxX;
    int maxY;

    public RoboMapHelper(List<String> input, int steps, int maxX, int maxY) {
        this.steps = steps;
        this.maxX = maxX;
        this.maxY = maxY;
        for (String s : input) {
            String[] split = s.split(" ");
            int px = Integer.parseInt(split[0].split("=")[1].split(",")[0]);
            int py = Integer.parseInt(split[0].split("=")[1].split(",")[1]);
            int vx = Integer.parseInt(split[1].split("=")[1].split(",")[0]);
            int vy = Integer.parseInt(split[1].split("=")[1].split(",")[1]);
            Robo robo = new Robo(new Coordinate(px, py), vx, vy);
            robos.add(robo);
        }
    }

    public long calc1() {
        List<Coordinate> endPositions = new ArrayList<>();
        for (Robo robo : robos) {
            Coordinate pos = getPositionInMap(robo.getPositionAfterSteps(steps));
            endPositions.add(pos);
        }
        return calcSafetyFactor(endPositions);
    }

    private long calcSafetyFactor(List<Coordinate> endPositions) {
        int xSplitter = maxX / 2;
        int ySplitter = maxY / 2;

        long s1 = endPositions.stream().filter(i -> i.x() < xSplitter && i.y() < ySplitter).count();
        long s2 = endPositions.stream().filter(i -> i.x() > xSplitter && i.y() < ySplitter).count();
        long s3 = endPositions.stream().filter(i -> i.x() < xSplitter && i.y() > ySplitter).count();
        long s4 = endPositions.stream().filter(i -> i.x() > xSplitter && i.y() > ySplitter).count();

        return s1 * s2 * s3 * s4;
    }

    private Coordinate getPositionInMap(Coordinate position) {
        int x = (int) (position.x() % maxX);
        int y = (int) (position.y() % maxY);
        if (x < 0) {
            x = maxX + x;
        }
        if (y < 0) {
            y = maxY + y;
        }

        return new Coordinate(x, y);
    }
}

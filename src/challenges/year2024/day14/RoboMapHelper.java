package challenges.year2024.day14;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class RoboMapHelper {

    private final List<Robot> robots = new ArrayList<>();
    private final int steps;
    private final int maxX;
    private final int maxY;

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
            Robot robot = new Robot(new Coordinate(px, py), vx, vy);
            robots.add(robot);
        }
    }

    public long calc1() {
        List<Coordinate> endPositions = new ArrayList<>();
        for (Robot robot : robots) {
            Coordinate pos = getPositionInMap(robot.getPositionAfterSteps(steps));
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

    public int calc2() {
        double minSd = Double.MAX_VALUE;
        List<Coordinate> positions = new ArrayList<>();
        int step = 0;
        for (int i = 0; i < 10000; i++) {
            List<Coordinate> endPositions = new ArrayList<>();
            for (Robot robot : robots) {
                Coordinate pos = getPositionInMap(robot.getPositionAfterSteps(i));
                endPositions.add(pos);
            }
            double sd = calcStandardDeviation(endPositions);
            if (sd < minSd) {
                minSd = sd;
                positions = endPositions;
                step = i;
            }
        }
        print(positions);
        return step;
    }

    private void print(List<Coordinate> positions) {
        for (int y = maxY; y >= 0; y--) {
            String s = "";
            for (int x = 0; x < maxX; x++) {
                if (positions.contains(new Coordinate(x, y))) {
                    s += "@";
                } else {
                    s += ".";
                }
            }
            System.out.println(s);
        }
    }

    private double calcStandardDeviation(List<Coordinate> endPositions) {
        int n = endPositions.size();

        double meanX = endPositions.stream().mapToDouble(Coordinate::x).average().orElse(0.0);
        double varianceX = endPositions.stream().mapToDouble(c -> Math.pow(c.x() - meanX, 2)).sum() / n;
        double meanY = endPositions.stream().mapToDouble(Coordinate::y).average().orElse(0.0);
        double varianceY = endPositions.stream().mapToDouble(c -> Math.pow(c.y() - meanY, 2)).sum() / n;

        return Math.sqrt(varianceX + varianceY);
    }
}

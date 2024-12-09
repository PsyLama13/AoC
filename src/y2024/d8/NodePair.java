package y2024.d8;

import helper.Coordinate;

import java.util.*;

public class NodePair {
    private Coordinate p1;
    private Coordinate p2;
    private int maxX;
    private int maxY;
    private Set<Coordinate> antiNodes = new HashSet<>();

    public NodePair(Coordinate p1, Coordinate p2, int maxX, int maxY) {
        this.p1 = p1;
        this.p2 = p2;
        this.maxX = maxX;
        this.maxY = maxY;

        calculateAntinodes();
    }

    private void calculateAntinodes() {

        int dx = p2.x() - p1.x();
        int dy = p2.y() - p1.y();

        Coordinate a1 = new Coordinate(p2.x() + dx, p2.y() + dy);
        Coordinate a2 = new Coordinate(p1.x() - dx, p1.y() - dy);
        for (Coordinate c : List.of(a1, a2)) {
            if (isOnMap(c)) {
                antiNodes.add(c);
            }
        }
    }

    private boolean isOnMap(Coordinate c) {
        return c.x() >= 0 && c.x() <= maxX && c.y() >= 0 && c.y() <= maxY;
    }

    public Set<Coordinate> getAntiNodes() {
        return antiNodes;
    }

    @Override
    public int hashCode() {
        return 32 * (p1.x() + p1.y() + p2.x() + p2.y());
    }

    public void printAntiNodes() {
        for (Coordinate i : antiNodes) {
            System.out.println(i.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{" + p1 + " " + p2 + "} \n");
        for (Coordinate c : antiNodes) {
            s.append(c).append(", ");
        }
        return s.substring(0, s.length() - 2);
    }
}

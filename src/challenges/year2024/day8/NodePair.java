package challenges.year2024.day8;

import helper.Coordinate;

import java.util.*;

public class NodePair {
    private final Coordinate p1;
    private final Coordinate p2;
    private final int maxX;
    private final int maxY;
    int dx;
    int dy;
    private final Set<Coordinate> antiNodes = new HashSet<>();
    private final Set<Coordinate> fullAntiNodes = new HashSet<>();

    public NodePair(Coordinate p1, Coordinate p2, int maxX, int maxY) {
        this.p1 = p1;
        this.p2 = p2;
        this.maxX = maxX;
        this.maxY = maxY;
        dx = (int) (p2.x() - p1.x());
        dy = (int) (p2.y() - p1.y());

        calculateAntiNodes();
        calculateFullAntiNodes();
    }

    private void calculateFullAntiNodes() {
        calcUpwards();
        calcDownwards();
    }

    private void calcDownwards() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Coordinate c = new Coordinate(p1.x() - i * dx, p1.y() - i * dy);
            if (isOnMap(c)) {
                fullAntiNodes.add(c);
            } else {
                return;
            }
        }
    }

    private void calcUpwards() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Coordinate c = new Coordinate(p2.x() + i * dx, p2.y() + i * dy);
            if (isOnMap(c)) {
                fullAntiNodes.add(c);
            } else {
                return;
            }
        }
    }

    private void calculateAntiNodes() {

        Coordinate a1 = new Coordinate(p2.x() + dx, p2.y() + dy);
        Coordinate a2 = new Coordinate(p1.x() - dx, p1.y() - dy);
        for (Coordinate c : List.of(a1, a2)) {
            if (isOnMap(c)) {
                antiNodes.add(c);
            }
        }
    }

    private boolean isOnMap(Coordinate c) {
        return c.x() >= 0 && c.x() < maxX && c.y() >= 0 && c.y() < maxY;
    }

    public Set<Coordinate> getAntiNodes() {
        return antiNodes;
    }

    public Set<Coordinate> getFullAntiNodes() {
        return fullAntiNodes;
    }

    @Override
    public int hashCode() {
        return (int) (32 * (p1.x() + p1.y() + p2.x() + p2.y()));
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

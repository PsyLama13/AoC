package challenges.year2025.day09;

import helper.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Line(Coordinate c1, Coordinate c2) {
    public static Set<Line> lineSetFromCoordinates(List<Coordinate> coordinates) {
        Set<Line> lines = new HashSet<>();
        for (int i = 0; i < coordinates.size() - 1; i++) {
            Coordinate c1 = coordinates.get(i);
            Coordinate c2 = coordinates.get(i + 1);
            lines.add(new Line(c1, c2));
        }
        lines.add(new Line(coordinates.getFirst(), coordinates.getLast()));
        return lines;
    }

    public boolean isHorizontalLine() {
        return !c1.equals(c2) && c1.y() == c2.y();
    }

    public boolean isVerticalLine() {
        return !c1.equals(c2) && c1.x() == c2.x();
    }
}
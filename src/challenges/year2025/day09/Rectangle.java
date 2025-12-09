package challenges.year2025.day09;

import helper.Coordinate;

public class Rectangle {
    private final long minX;
    private final long maxX;
    private final long minY;
    private final long maxY;

    public Rectangle(Coordinate c1, Coordinate c2) {
        minX = Math.min(c1.x(), c2.x());
        maxX = Math.max(c1.x(), c2.x());
        minY = Math.min(c1.y(), c2.y());
        maxY = Math.max(c1.y(), c2.y());
    }

    public boolean intersects(Line line) {
        if (line.isHorizontalLine()) {
            long y = line.c1().y();

            if (y > minY && y < maxY) {
                long lineMinX = Math.min(line.c1().x(), line.c2().x());
                long lineMaxX = Math.max(line.c1().x(), line.c2().x());

                return lineMaxX > minX && lineMinX < maxX;
            }
            return false;
        }

        if (line.isVerticalLine()) {
            long x = line.c1().x();

            if (x > minX && x < maxX) {
                long lineMinY = Math.min(line.c1().y(), line.c2().y());
                long lineMaxY = Math.max(line.c1().y(), line.c2().y());

                return lineMaxY > minY && lineMinY < maxY;
            }
            return false;
        }

        throw new IllegalStateException("only implemented for orthogonal lines");
    }

    public long getArea() {
        long side1 = maxX - minX + 1;
        long side2 = maxY - minY + 1;
        return side1 * side2;
    }
}
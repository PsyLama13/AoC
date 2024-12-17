package challenges.year2024.day14;

import helper.Coordinate;

public class Robo {
    Coordinate startPosition;
    int velX;
    int velY;

    public Robo(Coordinate startPosition, int velX, int velY) {
        this.startPosition = startPosition;
        this.velX = velX;
        this.velY = velY;
    }

    public Coordinate getPositionAfterSteps(int steps) {
        return new Coordinate(startPosition.x() + (long) velX * steps, startPosition.y() + (long) velY * steps);
    }
}

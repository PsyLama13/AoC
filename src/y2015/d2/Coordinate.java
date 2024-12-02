package y2015.d2;

public record Coordinate(int x, int y) {
    // the grid is starting at the top left, so y++ means going down and x++ means going right
    public Coordinate getNeighbour(Direction direction){
        return switch (direction){
            case UP -> new Coordinate(x,y-1);
            case DOWN -> new Coordinate(x,y+1);
            case LEFT -> new Coordinate(x-1,y);
            case RIGHT -> new Coordinate(x+1,y);
        };
    }
}

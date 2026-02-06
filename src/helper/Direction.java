package helper;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public boolean isOppositeDirection(Direction direction) {
        return switch (direction) {
            case UP -> this.equals(DOWN);
            case DOWN -> this.equals(UP);
            case LEFT -> this.equals(RIGHT);
            case RIGHT -> this.equals(LEFT);
        };
    }

    public static Direction getDirectionFromString(String s){
        return switch (s){
            case "U" -> UP;
            case "D" -> DOWN;
            case "L" -> LEFT;
            case "R" -> RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}

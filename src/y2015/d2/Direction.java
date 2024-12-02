package y2015.d2;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction parseDirection(Character c){
        return switch (c){
            case '>' -> RIGHT;
            case '<' -> LEFT;
            case '^' -> UP;
            case 'v' -> DOWN;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }
}

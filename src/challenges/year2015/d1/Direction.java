package challenges.year2015.d1;

public enum Direction {
    UP,
    DOWN;

    public static Direction parseDirection(Character s){
        return switch (s){
            case '(' -> UP;
            case ')' -> DOWN;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}

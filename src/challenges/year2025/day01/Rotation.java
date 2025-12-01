package challenges.year2025.day01;

public enum Rotation {
    LEFT("L"),
    RIGHT("R");

    private final String value;
    Rotation(String s){
        this.value = s;
    }

    @Override
    public String toString(){
        return value;
    }

    public static Rotation fromString(String s){
        return switch (s){
            case "L" -> LEFT;
            case "R" -> RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}

package challenges.year2025.day06;

public enum Operator {
    PLUS("+"),
    MULT("*");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator fromString(String value) {
        return switch (value){
            case "+" -> PLUS;
            case "*" -> MULT;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

    public String getValue() {
        return value;
    }
}

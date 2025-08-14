package challenges.year2024.day24;

public enum GateType {
    AND,
    OR,
    XOR;

    public static GateType parse(String string) {
        return switch (string) {
            case "AND" -> AND;
            case "OR" -> OR;
            case "XOR" -> XOR;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}

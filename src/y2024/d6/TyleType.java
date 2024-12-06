package y2024.d6;

public enum TyleType {
    OPEN, BLOCKED;

    public static TyleType parseTyleType(String s) {
        if (s.equals(".")) {
            return OPEN;
        }

        if (s.equals("#")) {
            return BLOCKED;
        }
        return null;
    }

    public String toString() {
        return switch (this) {
            case OPEN -> ".";
            case BLOCKED -> "#";
        };
    }
}

package y2024.d6;

public enum TileType {
    OPEN, BLOCKED;

    public static TileType parseTileType(String s) {
        if (s.equals(".")) {
            return OPEN;
        }

        if (s.equals("#")) {
            return BLOCKED;
        }
        return null;
    }

    @Override
    public String toString() {
        return switch (this) {
            case OPEN -> ".";
            case BLOCKED -> "#";
        };
    }
}

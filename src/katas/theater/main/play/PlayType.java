package katas.theater.main.play;

public enum PlayType {
    TRAGEDY("tragedy"),
    COMEDY("comedy");

    private final String value;

    private PlayType(String value) {
        this.value = value;
    }

    public static PlayType fromString(String value) {
        for (PlayType playType : values()) {
            if (value.equals(playType.value)) {
                return playType;
            }
        }
        throw new IllegalArgumentException("unknown type: " + value);
    }
}

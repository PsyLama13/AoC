package challenges.year2015.d6;

public enum CommandType {
    TURN_ON("turn on"),
    TURN_OFF("turn off"),
    TOGGLE("toggle");

    private final String s;
    CommandType(String s) {
        this.s = s;
    }

    public String getString(){
        return s;
    }

    public static CommandType parseCommandType(String s){
        return switch (s){
            case "turn on" -> TURN_ON;
            case "turn off" -> TURN_OFF;
            case "toggle" -> TOGGLE;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}

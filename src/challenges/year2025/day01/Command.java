package challenges.year2025.day01;

public record Command(Rotation rotation, Integer value) {
    public static Command fromString(String s){
        String rotString = s.substring(0,1);
        String numString = s.substring(1);

        Rotation rot = Rotation.fromString(rotString);
        Integer num = Integer.parseInt(numString);
        return new Command(rot, num);
    }

    public Integer getZeroTurnovers(Integer currentValue) {
        Integer turnovers = value / 100;
        Integer rest = value % 100;
        if(hasOverflow(rest, currentValue)){
            turnovers++;
        }

        return turnovers;
    }

    private boolean hasOverflow(Integer rest, Integer currentValue) {
        return switch (rotation){
            case LEFT -> currentValue - rest <= 0 && currentValue != 0;
            case RIGHT -> currentValue + rest > 99 && currentValue != 0;
        };
    }
}

package other.tempokleinefische;

import java.util.Random;

public enum Color {
    RED,
    GREEN,
    YELLOW,
    BLUE,
    PINK,
    ORANGE;

    private static final Random RANDOM = new Random();

    public static Color getRandomColor() {
        Color[] values = Color.values();
        return values[RANDOM.nextInt(values.length)];
    }
}

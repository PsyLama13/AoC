package other;

import java.util.List;
import java.util.Random;

public enum Color {
    RED,
    GREEN,
    YELLOW,
    PINK,
    BLUE,
    ORANGE;

    private static final List<Color> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Color rollDice() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

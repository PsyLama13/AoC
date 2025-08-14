package other.tempokleinefische;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Game {

    int fisherPosition = 0;

    Map<Color, Integer> fishToPositionMap = new EnumMap<>(Color.class);
    List<Color> saved;
    List<Color> caught;

    public Game(int offset) {
        caught = List.of(Color.GREEN, Color.RED);
        saved = new ArrayList<>();

        int startPosition = 5 + offset;
        fishToPositionMap.put(Color.YELLOW, startPosition);
        fishToPositionMap.put(Color.BLUE, startPosition);
        fishToPositionMap.put(Color.PINK, startPosition);
        fishToPositionMap.put(Color.ORANGE, startPosition);
    }

    public boolean playGame() {

        while (true) {
            Color color = Color.getRandomColor();

            if (caught.contains(color)) { //Fischer sind dran
                fisherPosition++;
            } else { // Fische sind dran
                if (saved.contains(color)) {
                    moveLastForward();
                } else {
                    moveColorForward(color);
                }
            }

            handleCaughtFish();
            break;
        }

        return false;
    }

    private void handleCaughtFish() {
        for (Map.Entry<Color, Integer> i : fishToPositionMap.entrySet()) {

        }
    }

    private void moveColorForward(Color color) {
        fishToPositionMap.put(color, fishToPositionMap.get(color) + 1);
    }

    private void moveLastForward() {
        int minVal = Integer.MAX_VALUE;
        Color minColor = null;
        for (Map.Entry<Color, Integer> entry : fishToPositionMap.entrySet()) {
            if (entry.getValue() < minVal) {
                minVal = entry.getValue();
                minColor = entry.getKey();
            }
        }
        fishToPositionMap.put(minColor, fishToPositionMap.get(minColor) + 1);
    }

}

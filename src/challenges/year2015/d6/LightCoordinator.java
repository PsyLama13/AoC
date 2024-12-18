package challenges.year2015.d6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightCoordinator {

    List<Command> instructions = new ArrayList<>();
    long[][] lightGrid = new long[1000][1000];

    public LightCoordinator(List<String> input) {
        for (String string : input) {
            instructions.add(new Command(string));
        }

        for(long[] row : lightGrid){
            Arrays.fill(row, 0L);
        }
    }

    public long handleInstructionsAndCountLights() {
        for (Command command : instructions) {
            handleCommand(command);
        }

        return countLights();
    }

    private long countLights() {
        long count = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                count += lightGrid[x][y];
            }
        }
        return count;
    }

    private void handleCommand(Command command) {
        int minX = Math.min(command.start.x(), command.end.x());
        int maxX = Math.max(command.start.x(), command.end.x());
        int minY = Math.min(command.start.y(), command.end.y());
        int maxY = Math.max(command.start.y(), command.end.y());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                switch (command.commandType) {
                    case TURN_ON -> {
                        lightGrid[x][y] += 1;
                    }
                    case TURN_OFF -> {
                        lightGrid[x][y] = Math.max(0, lightGrid[x][y] - 1);
                    }
                    case TOGGLE -> {
                        lightGrid[x][y] += 2;
                    }
                }
            }
        }
    }
}

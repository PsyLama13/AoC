package challenges.year2025.day01;

import java.util.ArrayList;
import java.util.List;

public class SafeSolver {
    List<Command> commandList = new ArrayList<>();
    Integer currentValue;
    Integer zeroRounds;

    public SafeSolver(List<String> debug) {
        for (String s : debug) {
            Command command = Command.fromString(s);
            commandList.add(command);
        }
    }

    public Integer solve1() {
        currentValue = 50;
        zeroRounds = 0;
        for (Command command : commandList) {
            applyCommand(command);
            applyZeroRound();
        }

        return zeroRounds;
    }

    public Integer solve2() {
        currentValue = 50;
        zeroRounds = 0;
        for (Command command : commandList) {
            handleZeroTurnOvers(command);
            applyCommand(command);
            printCommand(command);
        }

        return zeroRounds;
    }

    private void applyZeroRound() {
        if (currentValue == 0) {
            zeroRounds++;
        }
    }

    private void applyCommand(Command command) {
        switch (command.rotation()) {
            case LEFT -> currentValue -= command.value();
            case RIGHT -> currentValue += command.value();
            default -> throw new IllegalStateException("Unexpected value: " + command.rotation());
        }
        handleOverflow();
    }

    private void handleOverflow() {
        currentValue = Math.floorMod(currentValue, 100);
    }

    private void printCommand(Command command) {
        IO.println(currentValue + " after " + command.rotation().toString() + command.value() + ": zeros are " + zeroRounds);
    }

    private void handleZeroTurnOvers(Command command) {
        zeroRounds += command.getZeroTurnovers(currentValue);
    }
}
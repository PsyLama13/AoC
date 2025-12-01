package challenges.year2025.day01;

import java.util.ArrayList;
import java.util.List;

public class SafeSolver {
    List<Command> commandList = new ArrayList<>();
    Integer currentValue;
    Integer zerorounds = 0;

    public SafeSolver(List<String> debug) {
        currentValue = 50;

        for (String s : debug) {
            Command command = Command.fromString(s);
            commandList.add(command);
        }
    }

    public Integer solve1(){
        for(Command command : commandList){
            applyCommand(command);
            applyZeroRound(command);
        }

        return zerorounds;
    }

    private void applyZeroRound(Command command) {
        if(currentValue == 0){
            zerorounds ++;
        }
    }

    private void applyCommand(Command command) {
        switch (command.rotation()){
            case LEFT -> {
                currentValue -= command.value();
            }
            case RIGHT -> {
                currentValue += command.value();
            }
        }

        handleOverflow();
    }

    private void handleOverflow() {
        currentValue = Math.floorMod(currentValue, 100);
    }

    public Integer solve2() {

        for(Command command : commandList){
            handleZeroTurnOvers(command);
            applyCommand(command);
            printCommand(command);
        }

        return zerorounds;
    }

    private void printCommand(Command command) {
        IO.println(currentValue +" after " + command.rotation().toString() + command.value() + ": zeros are " + zerorounds);
    }

    private void handleZeroTurnOvers(Command command) {
        zerorounds += command.getZeroTurnovers(currentValue);
    }
}

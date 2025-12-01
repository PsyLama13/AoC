package challenges.year2019.day2;

import java.util.ArrayList;
import java.util.List;

public class IntcodeHelper {
    List<Integer> intcodeList = new ArrayList<>();
    int currentPosition = 0;

    public IntcodeHelper(List<String> input) {
        for (String s : input) {
            String[] numList = s.split(",");
            for (String numString : numList) {
                intcodeList.add(Integer.parseInt(numString));
            }
        }
    }

    Integer calc1() {
        intcodeList.set(1, 12);
        intcodeList.set(2, 2);
        return runProgram();
    }

    Integer calc2(){
        return  null;
    }

    private int runProgram(){
        while (true) {
            int opCode = intcodeList.get(currentPosition);
            switch (opCode) {
                case 1: {
                    handleAddition();
                    break;
                }
                case 2: {
                    handleMultiplication();
                    break;
                }
                case 99: {
                    return intcodeList.getFirst();
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
            currentPosition += 4;
        }
    }

    private void handleMultiplication() {
        int pos1 = intcodeList.get(currentPosition + 1);
        int pos2 = intcodeList.get(currentPosition + 2);
        int storageTarget = intcodeList.get(currentPosition + 3);

        int val1 = intcodeList.get(pos1);
        int val2 = intcodeList.get(pos2);
        int newVal = val1 * val2;

        intcodeList.set(storageTarget, newVal);
    }

    private void handleAddition() {
        int pos1 = intcodeList.get(currentPosition + 1);
        int pos2 = intcodeList.get(currentPosition + 2);
        int storageTarget = intcodeList.get(currentPosition + 3);

        int val1 = intcodeList.get(pos1);
        int val2 = intcodeList.get(pos2);
        int newVal = val1 + val2;

        intcodeList.set(storageTarget, newVal);
    }
}

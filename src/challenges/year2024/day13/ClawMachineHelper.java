package challenges.year2024.day13;

import java.util.ArrayList;
import java.util.List;

public class ClawMachineHelper {
    List<ClawMachine> clawMachines = new ArrayList<>();

    public ClawMachineHelper(List<String> input) {

        List<String> clawString = new ArrayList<>();
        for (String s : input) {
            if (!s.isEmpty()) {
                clawString.add(s);
            } else {
                ClawMachine clawMachine = new ClawMachine(clawString);
                clawMachines.add(clawMachine);
                clawString = new ArrayList<>();
            }
        }
        ClawMachine clawMachine = new ClawMachine(clawString);
        clawMachines.add(clawMachine);
    }

    public int calc1() {
        int counter = 0;
        for (ClawMachine clawMachine : clawMachines) {
            clawMachine.trySolveMachine();
            if (clawMachine.isSolvable()) {
                counter += clawMachine.getPriceSpending() == null ? 0 : clawMachine.getPriceSpending();
            }
        }
        return counter;
    }

    public long calc2() {
        long counter = 0;
        for (ClawMachine clawMachine : clawMachines) {
            clawMachine.trySolveExtendedMachine();
            if (clawMachine.isSolvable()) {
                counter += clawMachine.getPriceSpending();
            }
        }
        return counter;
    }
}

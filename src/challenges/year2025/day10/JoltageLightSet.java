package challenges.year2025.day10;

import java.util.ArrayList;
import java.util.List;

public record JoltageLightSet(LightSet lightSet, List<Integer> joltages) {
    public JoltageLightSet handleButtonPress(Button button) {
        LightSet ls = lightSet.handleButtonPress(button);
        List<Integer> jolt = handleJoltage(button);
        return new JoltageLightSet(ls, jolt);
    }

    private List<Integer> handleJoltage(Button button) {
        List<Integer> temp = new ArrayList<>(joltages);
        for (Integer i : button.lightSwitches()) {
            temp.set(i, temp.get(i) + 1);
        }
        return temp;
    }
}
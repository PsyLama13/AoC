package challenges.year2025.day10;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<Machine> machines = new ArrayList<>();

    public Factory(List<String> input) {
        for (String s : input) {
            machines.add(new Machine(s));
        }
    }

    public long solve() {
        return machines.stream().mapToLong(Machine::getFewestButtonSwitches).sum();
    }

    public long solve2(){
        return machines.stream().mapToLong(Machine::getFewestButtonSwitchesWithJoltage).sum();
    }
}

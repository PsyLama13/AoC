package challenges.year2025.day03;

import java.util.ArrayList;
import java.util.List;

public class BatteryBlock {
    List<BatteryBank> batteryBanks = new ArrayList<>();
    public BatteryBlock(List<String> input) {
        for(String string : input){
            batteryBanks.add(BatteryBank.fromString(string));
        }
    }

    public Long findTotalestJoltage(int numberLength) {
        return batteryBanks.stream().mapToLong(batterybank -> batterybank.findHigherestJoltageOutput(numberLength)).sum();
    }
}

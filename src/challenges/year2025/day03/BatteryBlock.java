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

    public Long findTotalJoltage(int numberLength) {
        return batteryBanks.stream().mapToLong(batterybank -> batterybank.findHighestJoltage(numberLength)).sum();
    }
}

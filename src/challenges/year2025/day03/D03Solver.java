package challenges.year2025.day03;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class D03Solver {
    private D03Solver(){
        throw new IllegalStateException();
    }
    public static void main() throws IOException {
        List<String> debug = Helper.readInput("year2025/d3d.txt");
        List<String> input = Helper.readInput("year2025/d3.txt");

        BatteryBlock testBatteryBlock = new BatteryBlock(debug);
        BatteryBlock batteryBlock = new BatteryBlock(input);

        IO.println(testBatteryBlock.findTotalestJoltage(2));
        IO.println(batteryBlock.findTotalestJoltage(2));

        IO.println(testBatteryBlock.findTotalestJoltage(12));
        IO.println(batteryBlock.findTotalestJoltage(12));
    }
}

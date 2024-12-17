package challenges.year2024.day13;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD13 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d13.txt");
        List<String> debug = Helper.readInput("year2024/d13d.txt");

        ClawMachineHelper clawMachineHelper = new ClawMachineHelper(input);

        //System.out.println(clawMachineHelper.calc1());
        System.out.println(clawMachineHelper.calc2());

    }

}

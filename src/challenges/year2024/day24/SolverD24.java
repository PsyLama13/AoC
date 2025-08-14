package challenges.year2024.day24;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD24 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d24.txt");
        List<String> debug = Helper.readInput("year2024/d24d.txt");
        List<String> debug2 = Helper.readInput("year2024/d24dd.txt");

        GateHelper gateHelper = new GateHelper(input);

        //BigInteger val = gateHelper.calc1();
        String val2 = gateHelper.calc2();
        System.out.println(val2);
    }
}

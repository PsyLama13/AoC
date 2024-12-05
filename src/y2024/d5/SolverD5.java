package y2024.d5;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD5 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2024/d5.txt");
        List<String> debug = Helper.readInput("y2024/d5d.txt");

        SafetyProtocolHelper safeteyProtocolHelper = new SafetyProtocolHelper(input);

        safeteyProtocolHelper.calc1And2();
    }
}

package y2020.d4;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD4 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2020/d4.txt");
        List<String> debug = Helper.readInput("y2020/d4d.txt");

        PassportScanner passportScanner = new PassportScanner(input);

        System.out.println(passportScanner.calc2());
    }
}

package challenges.year2020.d7;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD7 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2020/d7.txt");
        List<String> debug = Helper.readInput("year2020/d7d.txt");

        BagHelper bagHelper = new BagHelper(debug);

        System.out.println(bagHelper.calc1());
    }
}

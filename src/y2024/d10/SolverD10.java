package y2024.d10;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD10 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2024/d10.txt");
        List<String> debug = Helper.readInput("y2024/d10d.txt");

        TopographicHelper topo = new TopographicHelper(input);
        System.out.println(topo.calc1());
        System.out.println(topo.calc2());
    }
}

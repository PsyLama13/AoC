package y2020.d3;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD3 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2020/d3.txt");
        List<String> debug = Helper.readInput("y2020/d3d.txt");

        ToggobanCalculator t1 = new ToggobanCalculator(input, 1, 1);
        ToggobanCalculator t2 = new ToggobanCalculator(input, 3, 1);
        ToggobanCalculator t3 = new ToggobanCalculator(input, 7, 1);
        ToggobanCalculator t4 = new ToggobanCalculator(input, 5, 1);
        ToggobanCalculator t5 = new ToggobanCalculator(input,  1, 2);

        long tot = (long) t1.calc1() * t2.calc1() * t3.calc1() * t4.calc1() * t5.calc1();
        System.out.println(tot);
    }




}

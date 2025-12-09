package challenges.year2025.day07;

import helper.Helper;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day07 {

    List<String> debug = Helper.readInput("year2025/d7d.txt");
    List<String> input = Helper.readInput("year2025/d7.txt");

    @Test
    public void part1Test() {
        TachionHelper tachionHelper = new TachionHelper(debug);
        long val = tachionHelper.solve();
        assertEquals(21, val);
    }

    @Test
    public void part1(){
        TachionHelper tachionHelper = new TachionHelper(input);
        long val = tachionHelper.solve();
        IO.println(val);
    }

    @Test
    public void part2Test(){
        TachionHelper tachionHelper = new TachionHelper(debug);
        long val = tachionHelper.solve2();
        IO.println(val);
    }

    @Test
    public void part2(){
        TachionHelper tachionHelper = new TachionHelper(input);
        long val = tachionHelper.solve2();
        IO.println(val);
    }
}

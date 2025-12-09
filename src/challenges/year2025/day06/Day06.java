package challenges.year2025.day06;

import helper.Helper;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day06 {

    List<String> debug = Helper.readInput("year2025/d6d.txt");
    List<String> input = Helper.readInput("year2025/d6.txt");

    @Test
    public void part1Test() {
        MathSolver solver = new MathSolver(debug, true);
        long value = solver.solve();
        assertEquals(4277556, value);
    }

    @Test
    public void part1() {
        MathSolver solver = new MathSolver(input, true);
        long val = solver.solve();
        assertEquals(7229350537438L, val);
    }

    @Test
    public void part2Test(){
        MathSolver solver = new MathSolver(debug, false);
        long val = solver.solve();
        assertEquals(3263827, val);
    }

    @Test
    public void part2(){
        MathSolver solver = new MathSolver(input, false);
        long val = solver.solve();
        assertEquals(11479269003550L, val);
    }

}

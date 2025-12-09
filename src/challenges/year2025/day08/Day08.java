package challenges.year2025.day08;

import helper.Helper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day08 {
    List<String> debug = Helper.readInput("year2025/d8d.txt");
    List<String> input = Helper.readInput("year2025/d8.txt");

    @Test
    public void part1Test() {
        JunctionBoxMap junctionBox = new JunctionBoxMap(debug);
        long val = junctionBox.solve(10);
        assertEquals(40, val);
    }

    @Test
    public void part1() {
        JunctionBoxMap junctionBoxMap = new JunctionBoxMap(input);
        long val = junctionBoxMap.solve(1000);
        assertEquals(75680, val);
    }

    @Test
    public void part2Test() {
        JunctionBoxMap junctionBoxMap = new JunctionBoxMap(debug);
        long val = junctionBoxMap.solve2();
        assertEquals(25272, val);
    }

    @Test
    public void part2() {
        JunctionBoxMap junctionBoxMap = new JunctionBoxMap(input);
        long val = junctionBoxMap.solve2();
        assertEquals(8995844880L, val);
    }
}

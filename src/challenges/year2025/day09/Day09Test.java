package challenges.year2025.day09;

import helper.Helper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day09Test {

    List<String> debug = Helper.readInput("year2025/d9d.txt");
    List<String> input = Helper.readInput("year2025/d9.txt");

    @Test
    public void part1Test() {
        GridList gridList = new GridList(debug);
        long val = gridList.getBiggestSpanningArea();
        IO.println(val);
        assertEquals(50, val);
    }

    @Test
    public void part1() {
        GridList gridList = new GridList(input);
        long val = gridList.getBiggestSpanningArea();
        IO.println(val);
        assertEquals(4777409595L, val);
    }

    @Test
    public void part2Test() {
        GridList gridList = new GridList(debug);
        long val = gridList.getBiggestSpanningAreaInsideArea();
        assertEquals(24, val);
    }

    @Test
    public void part2() {
        GridList gridList = new GridList(input);
        long val = gridList.getBiggestSpanningAreaInsideArea();
        IO.println(val);
        assertEquals(1473551379L, val);
    }
}

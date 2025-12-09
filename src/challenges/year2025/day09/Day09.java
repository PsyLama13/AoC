package challenges.year2025.day09;

import helper.Helper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day09 {

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
    }
}

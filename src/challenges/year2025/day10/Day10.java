package challenges.year2025.day10;

import helper.Helper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day10 {

    List<String> debug = Helper.readInput("year2025/d10d.txt");
    List<String> input = Helper.readInput("year2025/d10.txt");
    @Test
    void part1Test(){
        Factory factory = new Factory(debug);
        long val = factory.solve();
        assertEquals(7, val);

    }

    @Test
    void part1(){
        Factory factory = new Factory(input);
        long val = factory.solve();
        IO.println(val);
    }


    @Test
    void part2Test(){
        Factory factory = new Factory(debug);
        long val = factory.solve2();
        IO.println(val);
    }
}

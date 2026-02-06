package challenges.year2025.day11;

import helper.Helper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day11 {

    List<String> debug = Helper.readInput("year2025/d11d.txt");
    List<String> debug2 = Helper.readInput("year2025/d11d2.txt");
    List<String> input = Helper.readInput("year2025/d11.txt");

    @Test
    void part1Test() {
        ServerRack serverRack = new ServerRack(debug, "you");
        long val = serverRack.solve();
        assertEquals(5, val);
    }

    @Test
    void part1() {
        ServerRack serverRack = new ServerRack(input, "you");
        long val = serverRack.solve();
        assertEquals(571, val);
    }

    @Test
    void part2Test() {
        ServerRack serverRack = new ServerRack(debug2, "svr");
        long val = serverRack.solve2();
        assertEquals(2, val);
    }

    @Test
    void part2(){
        ServerRack serverRack = new ServerRack(input, "svr");
        long val = serverRack.solve2();
        IO.println(val);
    }
}
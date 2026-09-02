package challenges.year2018.day03;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03 {

    List<String> input = Helper.readInput("year2018/d03.txt");
    List<String> debug = Helper.readInput("year2018/d03d.txt");

    @Test
    void part01Test() {
        FabricManager fabricManager = new FabricManager(debug);
        long result = fabricManager.calculateOverlap();
        Assertions.assertEquals(4, result);
    }

    @Test
    void part1() {
        FabricManager fabricManager = new FabricManager(input);
        long result = fabricManager.calculateOverlap();
        Assertions.assertEquals(113576, result);
    }

    @Test
    void part2() {
        FabricManager fabricManager = new FabricManager(input);
        int expectedId = fabricManager.getSoloId();
        Assertions.assertEquals(825, expectedId);
    }
}

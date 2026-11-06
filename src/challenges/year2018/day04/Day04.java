package challenges.year2018.day04;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day04 {
    List<String> debug = Helper.readInput("year2018/d04d.txt");
    List<String> input = Helper.readInput("year2018/d04.txt");

    @Test
    void part1Test() {
        GuardPost guardPost = new GuardPost(debug);
        Assertions.assertEquals(240, guardPost.strategyOne().answer());
    }

    @Test
    void part1() {
        GuardPost guardPost = new GuardPost(input);
        System.out.println(guardPost.strategyOne().answer());
    }

    @Test
    void part2Test() {
        GuardPost guardPost = new GuardPost(debug);
        Assertions.assertEquals(4455, guardPost.strategyTwo().answer());
    }

    @Test
    void part2() {
        GuardPost guardPost = new GuardPost(input);
        System.out.println(guardPost.strategyTwo().answer());
    }
}

package challenges.year2025.day04;

import helper.Helper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {

    @Test
    void part1Test() throws IOException {
        List<String> input = Helper.readInput("year2025/d4d.txt");
        PaperRollDiagram prd = new PaperRollDiagram(input);

        int rollCount = prd.getAccessiblePaperRollsCount();
        IO.println(rollCount);
        assertEquals(13, rollCount);
    }

    @Test
    void part1Check() throws IOException {
        List<String> input = Helper.readInput("year2025/d4.txt");
        PaperRollDiagram prd = new PaperRollDiagram(input);

        int rollCount = prd.getAccessiblePaperRollsCount();
        IO.println(rollCount);
        assertEquals(1537, rollCount);
    }

    @Test
    void part2Test() throws IOException {
        List<String> input = Helper.readInput("year2025/d4d.txt");
        PaperRollDiagram prd = new PaperRollDiagram(input);

        int rollCount = prd.getAccessiblePaperRollsCountRecursively();
        IO.println(rollCount);
        assertEquals(43, rollCount);
    }

    @Test
    void part2Check() throws IOException {
        List<String> input = Helper.readInput("year2025/d4.txt");
        PaperRollDiagram prd = new PaperRollDiagram(input);

        int rollCount = prd.getAccessiblePaperRollsCountRecursively();
        IO.println(rollCount);
        assertEquals(8707, rollCount);
    }
}
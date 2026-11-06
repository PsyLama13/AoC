package challenges.year2018.day05;

import helper.AocTest;
import helper.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05 extends AocTest {

    private static final Input EXAMPLE = Input.of("""
            dabAcCaCBAcCcaDA
            """);

    @Test
    void part1Example() {
        String polymer = EXAMPLE.text();// "dabAcCaCBAcCcaDA"
        PolymerSimulator polymerSimulator = new PolymerSimulator(polymer);
        String newPolymer = polymerSimulator.getSimulatedPolymer();
        assertEquals(10, newPolymer.length());
    }

    @Test
    void part1() {
        String polymer = input().text();   // src/resources/year2018/d05.txt, 50'000 units
        PolymerSimulator polymerSimulator = new PolymerSimulator(polymer);
        String newPolymer = polymerSimulator.getSimulatedPolymer();
        assertEquals(10564, newPolymer.length());
    }

    @Test
    void part2Example() {
        PolymerSimulator polymerSimulator = new PolymerSimulator(EXAMPLE.text());
        String shortestPolymer = polymerSimulator.getShortestImprovedPolymer();
        assertEquals(4, shortestPolymer.length());
    }

    @Test
    void part2() {
        PolymerSimulator polymerSimulator = new PolymerSimulator(input().text());
        String shortestPolymer = polymerSimulator.getShortestImprovedPolymer();
        System.out.println(shortestPolymer.length());
    }
}

package challenges.year2024.day22;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class SolverD22 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d22.txt");
        List<String> debug = Helper.readInput("year2024/d22d.txt");

        List<Monkey> monkeys;
        monkeys = calc1(input);
        calc2(monkeys);
    }

    private static List<Monkey> calc1(List<String> input) {
        List<Monkey> monkeys = new ArrayList<>();
        long counter = 0L;
        for (String string : input) {
            Monkey monkey = new Monkey(string);
            monkeys.add(monkey);
            counter += monkey.getCalc1Value();
        }
        long finalCounter = counter;
        logger.log(Level.INFO, () -> "part 1: " + finalCounter);
        return monkeys;
    }

    private static void calc2(List<Monkey> monkeys) {
        logger.log(Level.INFO, () -> "part 2: " + getMostBananas(monkeys));
    }

    private static int getMostBananas(List<Monkey> monkeys) {
        Set<String> visited = new HashSet<>();
        int bananaValue = Integer.MIN_VALUE;
        for (Monkey monkey : monkeys) {
            for (int i = 0; i < monkey.diffList.size() - 4; i++) {
                List<Long> diffList = monkey.getDiffRowAt(i);
                //List<Long> diffList = List.of(-2L,1L,-1L,3L);
                String key = getKey(diffList);
                if (!visited.contains(key)) {
                    visited.add(key);
                    int tempVal = calcBananaValue(monkeys, diffList);
                    if (tempVal > bananaValue) {
                        bananaValue = tempVal;
                    }
                }
            }
        }
        return bananaValue;
    }

    private static int calcBananaValue(List<Monkey> monkeys, List<Long> diffList) {
        int counter = 0;
        for (Monkey monkey : monkeys) {
            counter += monkey.getPriceForDiffList(diffList);
        }
        return counter;
    }

    private static String getKey(List<Long> diffList) {
        return diffList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}

package challenges.year2024.day17;

import helper.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolverD17 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d17.txt");
        List<String> debug = Helper.readInput("year2024/d17d.txt");

        //ElfComputer elfComputer = new ElfComputer(input);
        //System.out.println(elfComputer.calc1());
        calc2(input);
    }

    private static void calc2(List<String> input) {
        List<Integer> remaining = new ArrayList<>(List.of(2, 4, 1, 2, 7, 5, 1, 7, 4, 4, 0, 3, 5, 5, 3, 0));
        List<Integer> program = new ArrayList<>();
        long a = 0L;
        ElfComputer base = new ElfComputer(input);

        while (!remaining.isEmpty()) {
            --a;
            program.addFirst(remaining.removeLast());
            String pString = program.stream().map(Long::toString).collect(Collectors.joining(","));
            ElfComputer computer;
            String t;
            do {
                ++a;
                computer = new ElfComputer(a, base);
                t = computer.calc1();
            } while (!t.equals(pString));
            if (!remaining.isEmpty()) {
                a = a << 3;
            }
        }
        System.out.println(a);
    }
}

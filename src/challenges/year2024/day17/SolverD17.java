package challenges.year2024.day17;

import helper.Helper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SolverD17 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d17.txt");
        List<String> debug = Helper.readInput("year2024/d17d.txt");

        ElfComputer elfComputer = new ElfComputer(input);
        //System.out.println(elfComputer.calc1());
        calc2(input);
    }

    private static void calc2(List<String> input) {
        Long tester = 1000000000000000L;
        long startVal = tester;
        ElfComputer start = new ElfComputer(input);
        String checkString = start.getCheckString();
        while (true) {
            ElfComputer temp = new ElfComputer(tester, start.getRegB(), start.getRegC(), start.getValues());
            String outputString = temp.calc1();
            //String s = "input: " + tester + ", regB: " + temp.getRegB() + ", regC: " + temp.getRegC() + ", vals: " + outputString;
            //System.out.println(s);
            if (Objects.equals(start.getRegB(), temp.getRegB()) && Objects.equals(start.getRegC(), temp.getRegC()) && outputString.equals(checkString)) {
                System.out.println(tester);
                return;
            }
            tester++;
            /*
            if (tester > startVal + 100) {
                return;
            }

             */
        }

    }
}

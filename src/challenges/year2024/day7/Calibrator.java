package challenges.year2024.day7;

import java.util.ArrayList;
import java.util.List;

public class Calibrator {

    List<Equation> equations = new ArrayList<>();

    public Calibrator(List<String> input) {
        for (String s : input) {
            String[] split = s.split(": ");
            long result = Long.parseLong(split[0]);
            List<Long> vals = new ArrayList<>();
            String[] numStrings = split[1].split(" ");
            for (String numString : numStrings) {
                vals.add(Long.parseLong(numString));
            }

            Equation equation = new Equation(result, vals);
            equations.add(equation);
        }
    }

    public long calc1() {
        long count = 0;
        for(Equation equation : equations){
            if(equation.isSolvable()){
                count += equation.result;
            }
        }
        return count;
    }
}

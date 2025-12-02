package challenges.year2025.day02;

import java.util.ArrayList;
import java.util.List;

public class SequenceGenerator {
    List<NumberRange> rangeList = new ArrayList<>();

    public SequenceGenerator(List<String> input) {
        for (String s : input) {
            String[] arr = s.split(",");
            for (String sequence : arr) {
                rangeList.add(NumberRange.fromString(sequence));
            }
        }
    }

    public long calcSillySum(Integer repeater) {
        long output = 0L;
        for (NumberRange numberRange : rangeList) {
            output += numberRange.addUpInvalidIds(repeater);
        }
        return output;
    }
}

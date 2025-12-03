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

    public long calcSillySum(IdPredicate predicate) {
        return rangeList.stream().mapToLong(i -> i.addUpInvalidIds(predicate)).sum();
    }
}

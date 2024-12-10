package challenges.year2020.d1;

import java.util.ArrayList;
import java.util.List;

public class AccountingFixer {

    List<Integer> integers = new ArrayList<>();
    private static final int SUM = 2020;

    public AccountingFixer(List<String> input) {
        for (String s : input) {
            integers.add(Integer.parseInt(s));
        }
    }

    public Integer calcDay1() {
        for (Integer num : integers) {
            Integer other = SUM - num;
            if (integers.contains(other)) {
                return num * other;
            }
        }
        throw new IllegalStateException();
    }

    public Integer calcDay2() {
        for (int num1 : integers) {
            for (int num2 : integers) {
                int num3 = SUM - num1 - num2;
                if (integers.contains(num3)) {
                    return num1 * num2 * num3;
                }
            }
        }
        throw new IllegalStateException();
    }


}

package challenges.year2024.day2;

import java.util.ArrayList;
import java.util.List;

public class Report {

    List<Integer> levels = new ArrayList<>();

    public Report(String s) {
        List<String> numStrings = List.of(s.split(" "));
        for (String str : numStrings) {
            int num = Integer.parseInt(str);
            levels.add(num);
        }
    }

    public Report(List<Integer> list) {
        this.levels = list;
    }

    public boolean isSafe() {
        return allRightAmountDiff() && allDecreasingOrIncreasing();
    }

    private boolean allDecreasingOrIncreasing() {
        if (levels.get(0) > levels.get(1)) { // if decreasing
            for (int i = 1; i < levels.size(); i++) {
                int pre = levels.get(i - 1);
                int cur = levels.get(i);
                if (pre < cur) {
                    return false;
                }
            }
        } else { // if increasing
            for (int i = 1; i < levels.size(); i++) {
                int pre = levels.get(i - 1);
                int cur = levels.get(i);
                if (pre > cur) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean allRightAmountDiff() {
        for (int i = 1; i < levels.size(); i++) {
            int pre = levels.get(i - 1);
            int cur = levels.get(i);
            int dif = Math.abs(cur - pre);

            if (dif < 1 || dif > 3) {
                return false;
            }
        }
        return true;
    }

    public boolean isSafe2() {
        if (isSafe()) {
            return true;
        }

        for (int index = 0; index < levels.size(); index++) {
            List<Integer> subList = new ArrayList<>(levels);
            subList.remove(index);
            Report report = new Report(subList);
            if (report.isSafe()) {
                return true;
            }
        }
        return false;
    }
}
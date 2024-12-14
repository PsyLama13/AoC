package challenges.year2024.day5;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SafetyProtocolHelper {

    Map<Integer, List<Integer>> safetyRules = new HashMap<>();
    List<List<Integer>> orderList = new ArrayList<>();

    public SafetyProtocolHelper(List<String> input) {
        boolean ruleBreak = false;
        for (String string : input) {
            if (!ruleBreak) {
                if (string.isEmpty()) {
                    ruleBreak = true;
                    continue;
                }
                String[] splitter = string.split("\\|");
                int num1 = Integer.parseInt(splitter[0]);
                int num2 = Integer.parseInt(splitter[1]);
                if (safetyRules.containsKey(num1)) {
                    ArrayList<Integer> temp = new ArrayList<>(safetyRules.get(num1));
                    temp.add(num2);
                    safetyRules.put(num1, temp);
                } else {
                    safetyRules.put(num1, List.of(num2));
                }


            } else {
                String[] splitter = string.split(",");
                List<Integer> order = new ArrayList<>();
                for (String numString : splitter) {
                    int num = Integer.parseInt(numString);
                    order.add(num);
                }
                orderList.add(order);
            }

        }
    }

    public void calc1And2() {
        int count = 0;
        List<List<Integer>> wrongList = new ArrayList<>();
        for (List<Integer> l : orderList) {
            Coordinate c = getWrongNumberTuple(l);
            if (c == null) {
                count += getMiddleNumber(l);
            } else {
                wrongList.add(l);
            }
        }
        System.out.println(count);
        calc2(wrongList);
    }

    private void calc2(List<List<Integer>> wrongList) {
        int count = 0;
        for (List<Integer> l : wrongList) {
            ArrayList<Integer> temp = new ArrayList<>(l);
            temp = arrangeCorrectly(temp);
            count += getMiddleNumber(temp);
        }
        System.out.println(count);
    }

    private ArrayList<Integer> arrangeCorrectly(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>(input);
        Coordinate c = getWrongNumberTuple(input);
        insertNumberCorrectly(c.x(), output);

        return output;
    }

    private void insertNumberCorrectly(long num, ArrayList<Integer> list) {
        List<Integer> beforeList = safetyRules.get(num);
        int maxIndex = Integer.MAX_VALUE;
        for (int n : beforeList) {
            int index = list.indexOf(n);
            if (index != -1 && maxIndex > index) {
                maxIndex = index;
            }
        }
        int numIndex = list.indexOf(num);
        list.remove(numIndex);
        list.add(maxIndex, (int)num);

        Coordinate c = getWrongNumberTuple(list);
        if (c != null) {
            insertNumberCorrectly(c.x(), list);
        }
    }

    private int getMiddleNumber(List<Integer> l) {
        int index = l.size() / 2;
        return l.get(index);
    }

    private Coordinate getWrongNumberTuple(List<Integer> input) {
        for (int num : input) {
            Integer i = getWrongRuleNumber(num, input);
            if (i != null) {
                return new Coordinate(num, i);
            }
        }
        return null;
    }

    private Integer getWrongRuleNumber(int num, List<Integer> input) {
        int index = input.indexOf(num);
        List<Integer> numsBefore = input.subList(0, index);
        List<Integer> rules = safetyRules.get(num);
        if (rules != null) {
            for (int ruleNum : rules) {
                if (numsBefore.contains(ruleNum)) {
                    return ruleNum;
                }
            }
        }
        return null;
    }
}

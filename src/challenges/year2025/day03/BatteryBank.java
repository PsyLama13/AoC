package challenges.year2025.day03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BatteryBank {
    List<Integer> batteries;

    public static BatteryBank fromString(String string) {
        BatteryBank batteryBank = new BatteryBank();
        List<Integer> batteries = new ArrayList<>();
        for (String s : string.split("")) {
            batteries.add(Integer.parseInt(s));
        }
        batteryBank.batteries = batteries;
        return batteryBank;
    }

    public long findHighestJoltage(int numberLength) {
        List<Integer> maxNumberList = maxSubsequence(this.batteries, numberLength);
        StringBuilder numString = new StringBuilder();
        for(Integer number : maxNumberList){
            numString.append(number.toString());
        }

        return Long.parseLong(numString.toString());
    }

    public static List<Integer> maxSubsequence(List<Integer> batteries, int numberLength) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < batteries.size(); i++) {
            int current = batteries.get(i);

            int remaining = batteries.size() - i;

            while (!stack.isEmpty()
                    && stack.peekLast() < current
                    && stack.size() - 1 + remaining >= numberLength) {
                stack.pollLast();
            }

            if (stack.size() < numberLength) {
                stack.addLast(current);
            }
        }
        return new ArrayList<>(stack);
    }
}

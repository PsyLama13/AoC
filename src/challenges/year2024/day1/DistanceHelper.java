package challenges.year2024.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistanceHelper {

    private List<Integer> l1 = new ArrayList<>();
    private List<Integer> l2 = new ArrayList<>();

    public DistanceHelper(List<String> input) {
        for (String s : input) {
            List<String> arr = Stream.of(s.split(" ")).filter(str -> !str.isEmpty()).toList();

            int num1 = Integer.parseInt(arr.get(0));
            int num2 = Integer.parseInt(arr.get(1));

            l1.add(num1);
            l2.add(num2);
        }
    }

    public int calc1() {
        l1 = l1.stream().sorted().collect(Collectors.toList());
        l2 = l2.stream().sorted().collect(Collectors.toList());

        int counter = 0;
        for (int i = 0; i < l1.size(); i++) {
            counter += Math.abs(l1.get(i) - l2.get(i));
        }

        return counter;
    }

    public int calc2() {
        int counter = 0;

        for (Integer num : l1) {
            int frequency = Collections.frequency(l2, num);
            counter += num * frequency;
        }
        return counter;
    }
}
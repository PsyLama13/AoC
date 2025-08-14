package other.mario;

import java.util.ArrayList;
import java.util.List;

public class MarioSwimSuitTest {

    static int x;
    // Maximum value found
    static double maxValue = Double.NEGATIVE_INFINITY;
    // Store best sequence for debugging
    static List<String> bestSequence = new ArrayList<>();

    public static void main(String[] args) {
        x = 18; // Change this to the number of picks you want
        findMaxValue(0.0, 0, new ArrayList<>());
        System.out.println("Max Value: " + maxValue);
        System.out.println("Best Sequence: " + bestSequence);
    }

    // Recursive function to try all combinations
    static void findMaxValue(double currentValue, int depth, List<String> sequence) {
        if (depth == x) {
            if (currentValue > maxValue) {
                maxValue = currentValue;
                bestSequence = new ArrayList<>(sequence);
            }
            return;
        }

        // Try +1
        sequence.add("1 ");
        findMaxValue(currentValue + 13, depth + 1, sequence);
        sequence.removeLast();

        // Try *1.5
        sequence.add("2 ");
        findMaxValue(currentValue * 4.5, depth + 1, sequence);
        sequence.removeLast();

        // Try sqrt(x)*3
        sequence.add("3 ");
        findMaxValue(Math.pow(currentValue, 1) * 18, depth + 1, sequence);
        sequence.removeLast();
    }
}

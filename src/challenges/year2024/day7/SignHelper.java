package challenges.year2024.day7;

import java.util.ArrayList;
import java.util.List;

public class SignHelper {

    private SignHelper() {
        throw new IllegalStateException("Utility Class");
    }

    public static List<List<Operation>> generateOperatorList(int amount) {
        List<List<Operation>> results = new ArrayList<>();
        generatePermutationsRecursively(amount - 1, new ArrayList<>(), results);
        return results;
    }

    private static void generatePermutationsRecursively(int i, ArrayList<Operation> current, List<List<Operation>> results) {
        if (i == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        current.add(Operation.PLUS);
        generatePermutationsRecursively(i - 1, current, results);
        current.remove(current.size() - 1);

        current.add(Operation.MULT);
        generatePermutationsRecursively(i - 1, current, results);
        current.remove(current.size() - 1);

        current.add(Operation.CONCAT);
        generatePermutationsRecursively(i - 1, current, results);
        current.remove(current.size() - 1);
    }
}

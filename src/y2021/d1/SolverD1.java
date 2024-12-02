package y2021.d1;

import helper.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolverD1 {

    public static void main(String args[]) throws IOException {

        List<String> input = Helper.readInput("d1_debug.txt");
        List<Integer> numbers = parseNumbers(input);
        System.out.println(solveFirstPartOfPuzzle(numbers));
        System.out.println(solveSecondPartOfPuzzle(numbers));
    }

    private static int solveSecondPartOfPuzzle(List<Integer> numbers) {
        List<DepthTriplet> triplets = createTriplets(numbers);

        List<Integer> sumList = new ArrayList<>();
        for (DepthTriplet i : triplets) {
            Integer sum = i.getSum();
            sumList.add(sum);
        }

        return solveFirstPartOfPuzzle(sumList);
    }

    private static List<DepthTriplet> createTriplets(List<Integer> numbers) {

        List<DepthTriplet> output = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 2; i++) {
            int a = numbers.get(i);
            int b = numbers.get(i + 1);
            int c = numbers.get(i + 2);

            output.add(new DepthTriplet(a, b, c));
        }
        return output;
    }

    private static int solveFirstPartOfPuzzle(List<Integer> numbers) {

        int counter = 0;
        int current;
        int previous = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            current = numbers.get(i);
            if (current > previous) {
                counter++;
            }
            previous = current;
        }

        return counter;
    }

    private static List<Integer> parseNumbers(List<String> input) {

        List<Integer> output = new ArrayList<>();
        for (String s : input) {
            output.add(Integer.parseInt(s));
        }

        return output;
    }
}

package challenges.year2025.day06;

import java.util.ArrayList;
import java.util.List;

public class MathSolver {
    private final List<MathProblem> mathProblems = new ArrayList<>();

    public MathSolver(List<String> input, boolean isPart1) {
        if (isPart1) {
            handlePart1(input);

        } else {
            handlePart2(input);
        }
    }

    public long solve() {
        return mathProblems.stream().mapToLong(MathProblem::solve).sum();
    }

    // --------- private methods ---------------

    private void handlePart2(List<String> input) {
        handlePart2(input);
        List<String> temp = new ArrayList<>(input);
        List<String> signs = List.of(temp.removeLast().trim().split("\\s+"));
        temp = turnInput(temp);
        temp.replaceAll(s -> s.replace(" ", ""));
        initDataPart2(temp, signs);
    }

    private void handlePart1(List<String> input) {
        List<List<String>> structuredData = new ArrayList<>();
        for (String s : input) {
            structuredData.add(List.of(s.trim().split("\\s+")));
        }
        initData(structuredData);
    }

    private void initDataPart2(List<String> temp, List<String> operators) {
        List<Integer> numList = new ArrayList<>();
        int signCounter = 0;
        for (String s : temp) {
            if (s.isEmpty()) {
                Operator operator = Operator.fromString(operators.get(signCounter));
                mathProblems.add(new MathProblem(numList, operator));
                numList = new ArrayList<>();
                signCounter++;
            } else {
                numList.add(Integer.parseInt(s));
            }
        }
        Operator operator = Operator.fromString(operators.getLast());
        mathProblems.add(new MathProblem(numList, operator));
    }

    private List<String> turnInput(List<String> input) {
        List<String> output = new ArrayList<>();

        Integer maxLen = input.stream().map(i -> i.length()).max(Integer::compareTo).get();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder temp = new StringBuilder();
            for (String s : input) {
                String part = getCharacterFromString(i, s);
                temp.append(part);
            }
            output.add(temp.toString());
        }
        return output;
    }

    private String getCharacterFromString(int i, String s) {
        if (i >= s.length()) {
            return " ";
        }
        return String.valueOf(s.charAt(i));
    }

    private void initData(List<List<String>> data) {
        List<String> signs = data.removeLast();

        for (int i = 0; i < signs.size(); i++) {
            List<Integer> numList = new ArrayList<>();
            for (List<String> list : data) {
                numList.add(Integer.valueOf(list.get(i)));
            }
            Operator operator = Operator.fromString(signs.get(i));
            mathProblems.add(new MathProblem(numList, operator));
        }
    }
}
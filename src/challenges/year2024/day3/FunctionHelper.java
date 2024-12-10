package challenges.year2024.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionHelper {
    List<MemoryFunction> functionList = new ArrayList<>();
    List<MulFunction> mulFunctionList = new ArrayList<>();
    String input;

    public FunctionHelper(List<String> input) {
        this.input = convertInput(input);
        addAllMuls();
        addAllDos();
        addAllDonts();
    }

    private String convertInput(List<String> input) {
        StringBuilder temp = new StringBuilder();
        for (String s : input) {
            temp.append(s);
        }
        return temp.toString();
    }

    private void addAllDonts() {
        String regex = "don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int index = matcher.start();

            DontFunction dontFunction = new DontFunction(index);
            functionList.add(dontFunction);
        }
    }

    private void addAllDos() {
        String regex = "do\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int index = matcher.start();

            DoFunction doFunction = new DoFunction(index);
            functionList.add(doFunction);
        }
    }

    private void addAllMuls() {
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            int index = matcher.start();
            List<String> l = List.of(match.split(","));
            int num1 = Integer.parseInt(l.get(0).substring(4));
            int num2 = Integer.parseInt(l.get(1).substring(0, l.get(1).length() - 1));

            MulFunction mulFunction = new MulFunction(num1, num2, index);
            functionList.add(mulFunction);
            mulFunctionList.add(mulFunction);
        }
    }

    public int calc1() {
        int output = 0;
        for (MulFunction mulFunction : mulFunctionList) {
            output += mulFunction.getResult();
        }
        return output;
    }

    public int calc2() {
        int output = 0;
        functionList.sort(Comparator.comparing(MemoryFunction::getLocation));
        boolean enabled = true;
        for (MemoryFunction fun : functionList) {
            FunctionType type = fun.getFunctionType();
            switch (type) {
                case DO -> enabled = true;

                case DONT -> enabled = false;

                case MUL -> {
                    if (enabled) {
                        output += fun.getResult();
                    }
                }
            }
        }
        return output;
    }
}

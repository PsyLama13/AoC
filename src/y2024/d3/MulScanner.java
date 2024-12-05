package y2024.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MulScanner {
    List<String> mulStatements = new ArrayList<>();
    List<String> input = new ArrayList<>();

    public MulScanner(List<String> input) {
        String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        for (String str : input) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                mulStatements.add(matcher.group());
            }
        }

        this.input = input;
    }

    public int calc1() {
        return calcMuls(mulStatements);
    }

    public int calc2() {
        List<String> validResults = new ArrayList<>();
        String regex = "(don't\\(\\)|do\\(\\))\\s*mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        for (String str : input) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String conndition = matcher.group(1);
                String mulStatemanent = matcher.group();

                if ("do()".equals(conndition)) {
                    validResults.add(mulStatemanent.substring("do()".length()).trim());
                }
            }
        }
        return calcMuls(validResults);
    }

    public int calcMuls(List<String> input) {
        int count = 0;
        for (String str : input) {
            List<String> l = List.of(str.split(","));
            String nString1 = l.get(0).substring(4);
            String nString2 = l.get(1).substring(0, l.get(1).length() - 1);

            int n1 = Integer.parseInt(nString1);
            int n2 = Integer.parseInt(nString2);
            count += n1 * n2;
        }
        return count;
    }
}

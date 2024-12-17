package challenges.year2024.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElfComputer {

    private Long regA;
    private Long regB;
    private Long regC;
    private final List<Integer> values;

    public ElfComputer(List<String> debug) {
        regA = parseRegister(debug.get(0));
        regB = parseRegister(debug.get(1));
        regC = parseRegister(debug.get(2));
        values = parseOpCodes(debug.get(4));
    }

    public ElfComputer(Long regA, Long regB, Long regC, List<Integer> values) {
        this.regA = regA;
        this.regB = regB;
        this.regC = regC;
        this.values = values;
    }

    public Long getRegB() {
        return regB;
    }

    public Long getRegC() {
        return regC;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setRegA(Long val) {
        regA = val;
    }

    public boolean equals(ElfComputer o) {
        if (!Objects.equals(regB, o.regB) || !Objects.equals(regC, o.regC) || (values.size() != o.values.size())) {
            return false;
        }
        for (int i = 0; i < values.size(); i++) {
            if (!Objects.equals(values.get(i), o.values.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> parseOpCodes(String input) {
        List<Integer> output = new ArrayList<>();
        for (String s : input.split(" ")[1].split(",")) {
            output.add(Integer.parseInt(s));
        }
        return output;
    }

    private Long parseRegister(String s) {
        return Long.parseLong(s.split(" ")[2]);
    }

    public String calc1() {
        StringBuilder text = new StringBuilder();
        int pointer = 0;
        do {
            int opCode = values.get(pointer);
            int operand = values.get(pointer + 1);

            switch (opCode) {
                case 0 -> {
                    regA = (regA / (int) Math.pow(2, getCombo(operand)));
                    pointer += 2;
                }
                case 1 -> {
                    regB = regB ^ operand;
                    pointer += 2;
                }
                case 2 -> {
                    regB = getCombo(operand) % 8;
                    pointer += 2;
                }
                case 3 -> {
                    if (regA == 0) {
                        pointer += 2;
                    } else {
                        pointer = Math.toIntExact(operand);
                    }
                }
                case 4 -> {
                    regB = regB ^ regC;
                    pointer += 2;
                }
                case 5 -> {
                    text.append(getCombo(operand) % 8).append(",");
                    pointer += 2;
                }
                case 6 -> {
                    regB = (regA / (int) Math.pow(2, getCombo(operand)));
                    pointer += 2;
                }
                case 7 -> {
                    regC = (regA / (int) Math.pow(2, getCombo(operand)));
                    pointer += 2;
                }
            }
        } while (pointer < values.size());
        return text.toString().substring(0, text.length() - 1);
    }

    private Long getCombo(int operand) {
        if (operand <= 3) {
            return (long)operand;
        }
        if (operand == 4L) {
            return regA;
        }
        if (operand == 5L) {
            return regB;
        }
        if (operand == 6L) {
            return regC;
        }
        throw new IllegalStateException();
    }

    public String getCheckString() {
        StringBuilder output = new StringBuilder();
        for (int i : values) {
            output.append(i).append(",");
        }
        return output.substring(0, output.length() - 1);
    }
}

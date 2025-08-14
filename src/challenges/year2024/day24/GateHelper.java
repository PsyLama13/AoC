package challenges.year2024.day24;

import java.math.BigInteger;
import java.util.*;

public class GateHelper {
    Map<String, Boolean> valueMap = new HashMap<>();
    List<Gate> gates = new ArrayList<>();

    public GateHelper(List<String> input) {
        boolean isValues = true;
        for (String string : input) {
            if (string.isEmpty()) {
                isValues = false;
                continue;
            }
            if (isValues) {
                String[] split = string.split(": ");
                String name = split[0];
                Boolean bool = getBooleanFromNumberString(split[1]);
                valueMap.put(name, bool);
            } else {
                String[] split = string.split(" ");
                String val1 = split[0];
                String val2 = split[2];
                GateType type = GateType.parse(split[1]);
                String val3 = split[4];
                Gate gate = new Gate(val1, val2, val3, type);
                gates.add(gate);
                valueMap.putIfAbsent(val1, null);
                valueMap.putIfAbsent(val2, null);
                valueMap.putIfAbsent(val3, null);
            }
        }

        solveValueMap();
    }

    private void solveValueMap() {
        for(String outVar : valueMap.keySet()){
            Boolean val = valueMap.get(outVar);
            if(val == null){
                solveGate(outVar);
            }
        }
    }

    public String calc2() {
        List<Gate> faultyGates = findFaultyGates(gates);
        return getOutput(faultyGates);
    }

    private String getOutput(final List<Gate> faultyGates) {
        Collections.sort(faultyGates);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < faultyGates.size(); i++) {
            sb.append(faultyGates.get(i).getOutput());
            if (i < faultyGates.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private List<Gate> findFaultyGates(final List<Gate> gates) {
        final List<Gate> faultyGates = new ArrayList<>();
        /*
         * There are 4 cases in which is faulty:
         *
         * 1. If there is output to a z-wire, the operator should always be XOR (unless
         * it is the final bit). If not -> faulty.
         * 2. If the output is not a z-wire and the inputs are not x and y, the operator
         * should always be AND or OR. If not -> faulty.
         * 3. If the inputs are x and y (but not the first bit) and the operator is XOR,
         * the output wire should be the input of another XOR-gate. If not -> faulty.
         * 4. If the inputs are x and y (but not the first bit) and the operator is AND,
         * the output wire should be the input of an OR-gate. If not -> faulty.
         */
        for (final Gate c : gates) {
            if (c.getOutput().startsWith("z") && !c.getOutput().equals("z45")) {
                if (!c.getType().equals(GateType.XOR)) {
                    faultyGates.add(c);
                }
            } else if (!c.getOutput().startsWith("z")
                    && !(c.getInput1().startsWith("x") || c.getInput1().startsWith("y"))
                    && !(c.getInput2().startsWith("x") || c.getInput2().startsWith("y"))) {
                if (c.getType().equals(GateType.XOR)) {
                    faultyGates.add(c);
                }
            } else if (c.getType().equals(GateType.XOR)
                    && (c.getInput1().startsWith("x") || c.getInput1().startsWith("y"))
                    && (c.getInput2().startsWith("x") || c.getInput2().startsWith("y"))) {
                if (!(c.getInput1().endsWith("00") && c.getInput2().endsWith("00"))) {
                    final String output = c.getOutput();
                    boolean anotherFound = false;
                    for (final Gate c2 : gates) {
                        if (!c2.equals(c)) {
                            if ((c2.getInput1().equals(output) || c2.getInput2().equals(output))
                                    && c2.getType().equals(GateType.XOR)) {
                                anotherFound = true;
                                break;
                            }
                        }
                    }
                    if (!anotherFound) {
                        faultyGates.add(c);
                    }
                }
            } else if (c.getType().equals(GateType.AND)
                    && (c.getInput1().startsWith("x") || c.getInput1().startsWith("y"))
                    && (c.getInput2().startsWith("x") || c.getInput2().startsWith("y"))) {
                if (!(c.getInput1().endsWith("00") && c.getInput2().endsWith("00"))) {
                    final String output = c.getOutput();
                    boolean anotherFound = false;
                    for (final Gate c2 : gates) {
                        if (!c2.equals(c)) {
                            if ((c2.getInput1().equals(output) || c2.getInput2().equals(output))
                                    && c2.getType().equals(GateType.OR)) {
                                anotherFound = true;
                                break;
                            }
                        }
                    }
                    if (!anotherFound) {
                        faultyGates.add(c);
                    }
                }
            }
        }
        return faultyGates;
    }

    public BigInteger calc1() {
        return calcEndValue();
    }

    private BigInteger calcEndValue() {
        List<String> zVars = new ArrayList<>(valueMap.keySet().stream().filter(i -> i.startsWith("z")).toList());
        zVars.sort(Collections.reverseOrder());
        StringBuilder outputString = new StringBuilder();
        for (String zString : zVars) {
            boolean bool = valueMap.get(zString);
            String val = convertToOutput(bool);
            outputString.append(val);
        }

        return convertBinaryStringToNumber(outputString.toString());
    }

    private BigInteger convertBinaryStringToNumber(String string) {
        return new BigInteger(string, 2);
    }

    private void solveGate(String outVar) {
        while (valueMap.get(outVar) == null) {
            Gate gate = gates.stream().filter(i -> i.getOutput().equals(outVar)).findFirst().orElseThrow();

            Boolean val1 = valueMap.get(gate.getInput1());
            Boolean val2 = valueMap.get(gate.getInput2());

            if (val1 != null && val2 != null) {
                Boolean outputVal = gate.calc(val1, val2);
                valueMap.put(gate.getOutput(), outputVal);
            } else {
                solveGate(gate.getInput1());
                solveGate(gate.getInput2());
            }
        }
    }

    private String convertToOutput(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            return "1";
        } else {
            return "0";
        }
    }

    private Boolean getBooleanFromNumberString(String s) {
        return switch (s) {
            case "1" -> true;
            case "0" -> false;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}

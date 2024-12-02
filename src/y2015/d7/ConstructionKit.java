package y2015.d7;

import java.util.*;
import java.util.function.BiFunction;


public class ConstructionKit {

    Map<Variable, Integer> variableToSignalValue = new HashMap<>();
    Set<Statement> functionSet = new HashSet<>();

    public static BiFunction<Integer, Integer, Integer> bitAnd = (a, b) -> a & b;
    public static BiFunction<Integer, Integer, Integer> bitOr = (a, b) -> a | b;
    public static BiFunction<Integer, Integer, Integer> bitNot = (a, b) -> ~a;
    public static BiFunction<Integer, Integer, Integer> lShift = (a, b) -> a << b;
    public static BiFunction<Integer, Integer, Integer> rShift = (a, b) -> a >> b;
    public static BiFunction<Integer, Integer, Integer> assign = (a,b) -> a;


    public ConstructionKit(List<String> input) {
        for (String commandString : input) {
            handleCommandString(commandString);
        }
    }

    public int calculate(String key) {
        Variable v = new Variable(key, null);

        while (true) {
            Set<Statement> toRemove = new HashSet<>();
            if(variableToSignalValue.containsKey(v)){
                return variableToSignalValue.get(v);
            }

            for(Statement statement : functionSet){
                if(statement.canBeCalculated(variableToSignalValue) && !statement.solved){
                    Integer valA = variableToSignalValue.get(statement.inputA);
                    Integer valB = variableToSignalValue.get(statement.intputB);
                    variableToSignalValue.put(statement.outPut, statement.calc(valA, valB));
                    statement.solved = true;
                    toRemove.add(statement);
                }
            }

            functionSet.removeAll(toRemove);
        }
    }

    private void handleCommandString(String commandString) {

        String[] arr = commandString.split(" ");
        FunctionEnum e = getFunctionEnumForString(arr);


        switch (e) {
            case AND -> {
                String varA = arr[0];
                String varB = arr[2];
                String out = arr[4];
                Variable vA = new Variable(varA, null);
                //Statement statement = new Statement(varA, varB, out, bitAnd);
                //functionSet.add(statement);
            }
            case OR -> {
                String varA = arr[0];
                String varB = arr[2];
                String out = arr[4];
                //Statement statement = new Statement(varA, varB, out, bitOr);
                //functionSet.add(statement);
            }
            case LSHIFT -> {
                String varA = arr[0];
                String varB = arr[2];
                String out = arr[4];
                //Statement statement = new Statement(varA, varB, out, lShift);
                //functionSet.add(statement);
            }
            case RSHIFT -> {
                String varA = arr[0];
                String varB = arr[2];
                String out = arr[4];
                //Statement statement = new Statement(varA, varB, out, rShift);
                //functionSet.add(statement);
            }
            case NOT -> {
                String varA = arr[1];
                String out = arr[3];
                //Statement statement = new Statement(varA, null, out, bitNot);
                //functionSet.add(statement);
            }
            case ASSIGN -> {
                String varA = arr[2];
                try{
                    Integer val = Integer.parseInt(arr[0]);
                    //variableToSignalValue.put(varA, val);
                }catch (NumberFormatException e1){
                    String varB = arr[0];
                    //Statement statement = new Statement(varB, null, varA, assign);
                    //functionSet.add(statement);
                }

            }
        }

    }

    private FunctionEnum getFunctionEnumForString(String[] arr) {

        if(arr[1].equals("->")){
            return FunctionEnum.ASSIGN;
        }else {
            if (arr[0].equals("NOT")) {
                return FunctionEnum.NOT;
            } else {
                return switch (arr[1]) {
                    case "AND" -> FunctionEnum.AND;
                    case "OR" -> FunctionEnum.OR;
                    case "LSHIFT" -> FunctionEnum.LSHIFT;
                    case "RSHIFT" -> FunctionEnum.RSHIFT;
                    default -> throw new IllegalStateException("Unexpected value: " + arr[1]);
                };
            }
        }
    }
}

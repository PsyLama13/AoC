package challenges.year2015.d7;

import java.util.Map;
import java.util.function.BiFunction;

public class Statement {
    Variable inputA;
    Variable intputB;
    Variable outPut;
    BiFunction<Integer, Integer, Integer> fun;

    boolean solved = false;

    Integer sideInput;

    public Statement(Variable inputA, Variable inputB, Variable outPut, BiFunction<Integer, Integer, Integer> fun) {
        this.inputA = inputA;
        this.intputB = inputB;
        this.outPut = outPut;
        this.fun = fun;

        if(isShiftFun()){
            sideInput = Integer.parseInt(inputB.name());
        }
    }

    public Integer calc(Integer a, Integer b){
        if(isShiftFun()){{
            return fun.apply(a, sideInput);
        }}
        return fun.apply(a, b);
    }

    private boolean isShiftFun(){
        return fun.equals(ConstructionKit.lShift) || fun.equals(ConstructionKit.rShift);
    }

    public boolean canBeCalculated(Map<Variable, Integer> variableToSignalValue) {
        boolean canBeCalculated = variableToSignalValue.containsKey(inputA);
        if(intputB != null && sideInput == null){
            canBeCalculated = canBeCalculated & variableToSignalValue.containsKey(intputB);
        }
        return canBeCalculated;
    }
}

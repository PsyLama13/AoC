package challenges.year2024.day17;

public class OperationHelper {

    public static Integer calcValue(Integer opCode, Integer operand, Integer regA, Integer regB, Integer regC) {

        if (opCode.equals(0)) {
            return adv(operand, regA, regB, regC);
        }

        if (opCode.equals(1)) {
            return operand ^ regB;
        }

        if (opCode.equals(2)) {
            return getComboOperand(operand, regA, regB, regC) % 8;
        }

        if (opCode.equals(3)) {
            return operand;
        }

        if (opCode.equals(4)) {
            return regB ^ regC;
        }

        if (opCode.equals(5)) {
            return getComboOperand(operand, regA, regB, regC) % 8;
        }

        if (opCode.equals(6)) {
            return adv(operand, regA, regB, regC);
        }

        if (opCode.equals(7)) {
            return adv(operand, regA, regB, regC);
        }


        throw new IllegalStateException();
    }

    private static Integer getComboOperand(Integer operand, Integer regA, Integer regB, Integer regC) {
        if (operand.equals(0)) {
            return 0;
        }
        if (operand.equals(1)) {
            return 1;
        }
        if (operand.equals(2)) {
            return 2;
        }
        if (operand.equals(3)) {
            return 3;
        }
        if (operand.equals(4)) {
            return regA;
        }
        if (operand.equals(5)) {
            return regB;
        }
        if (operand.equals(6)) {
            return regC;
        }
        throw new IllegalStateException();
    }

    private static Integer adv(Integer operand, Integer regA, Integer regB, Integer regC) {
        if (getComboOperand(operand, regA, regB, regC) == 0) {
            throw new IllegalStateException();
        }
        int val = regA / (getComboOperand(operand, regA, regB, regC) * getComboOperand(operand, regA, regB, regC));
        return val;
    }
}

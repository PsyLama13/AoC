package challenges.year2024.day17;

public class OpCode {
    private Long opcode;
    private Long operand;
    Long regA;
    Long regB;
    Long regC;

    public OpCode(long opcode, long operand, long regA, long regB, long regC) {
        this.opcode = opcode;
        this.operand = operand;
        this.regA = regA;
        this.regB = regB;
        this.regC = regC;
    }

    public void performInstruction() {

    }

    private long getComboOperand() {
     return 1L;
    }
}

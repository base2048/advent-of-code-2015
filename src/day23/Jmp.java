package day23;

public class Jmp extends Instruction {

    public Jmp(char register, int argument) {
        super(Operation.JMP, register, argument);
    }
}

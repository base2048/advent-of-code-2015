package day23;

public class Inc extends Instruction {

    public Inc(char register, int argument) {
        super(Operation.INC, register, argument);
    }
}

package day23;

public class Instruction {

    private final Operation operation;
    private final char register;
    private final int argument;

    public Instruction(Operation operation, char register, int argument) {
        this.register = register;
        this.argument = argument;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public char getRegister() {
        return register;
    }

    public int getArgument() {
        return argument;
    }
}

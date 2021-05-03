package day23;

import java.util.List;

public class Computer {

    private Program program;
    private final Register register = new Register();

    public void run() {
        List<Instruction> code = program.getCode();
        Instruction instruction;
        int executionPointer = 0;

        while (executionPointer < code.size()) {
            instruction = code.get(executionPointer);
            switch (instruction.getOperation()) {
                case HLF -> {
                    register.set(instruction.getRegister(), register.get(instruction.getRegister()) >> 1);
                    executionPointer++;
                }
                case TPL -> {
                    register.set(instruction.getRegister(), register.get(instruction.getRegister()) * 3);
                    executionPointer++;
                }
                case INC -> {
                    register.set(instruction.getRegister(), register.get(instruction.getRegister()) + 1);
                    executionPointer++;
                }
                case JMP -> executionPointer += instruction.getArgument();
                case JIE -> {
                    if (register.get(instruction.getRegister()) % 2 == 0) executionPointer += instruction.getArgument();
                    else executionPointer++;
                }
                case JIO -> {
                    if (register.get(instruction.getRegister()) == 1) executionPointer += instruction.getArgument();
                    else executionPointer++;
                }
            }
        }
    }

    public Computer loadProgram(Program program) {
        this.program = program;
        return this;
    }

    public long getRegister(char register) {
        return this.register.get(register);
    }

    public Computer setRegister(char register, long value) {
        this.register.set(register, value);
        return this;
    }

    private static class Register {
        private long a = 0;
        private long b = 0;

        private long get(char register) {
            return switch (register) {
                case 'a' -> a;
                case 'b' -> b;
                default -> -1;
            };
        }

        private void set(char register, long value) {
            switch (register) {
                case 'a' -> a = value;
                case 'b' -> b = value;
            }
        }
    }
}

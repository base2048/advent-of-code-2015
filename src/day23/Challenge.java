package day23;

import java.util.List;

public class Challenge {

    private final Program program;

    public Challenge(List<Instruction> code) {
        this.program = new Program(code);
    }

    public long solvePart1() {
        Computer computer = new Computer();
        computer.loadProgram(program).run();
        return computer.getRegister('b');
    }

    public long solvePart2() {
        Computer computer = new Computer();
        computer.loadProgram(program).setRegister('a', 1).run();
        return computer.getRegister('b');
    }
}

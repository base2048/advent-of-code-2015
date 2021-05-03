package day23;

import java.util.List;

public class Program {

    private final List<Instruction> code;

    public Program(List<Instruction> code) {
        this.code = code;
    }

    public List<Instruction> getCode() {
        return code;
    }
}

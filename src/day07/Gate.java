package day07;

import java.util.function.ToIntBiFunction;

public enum Gate {

    AND((a, b) -> a & b),
    OR((a, b) -> a | b),
    RSHIFT((a, b) -> a >> b),
    LSHIFT((a, b) -> a << b),
    NOT((a, b) -> 0xFFFF - a),
    ASSIGN((a, b) -> a);

    private final ToIntBiFunction<Integer, Integer> operation;

    Gate(ToIntBiFunction<Integer, Integer> operation) {
        this.operation = operation;
    }

    public int execute(int signal1, int signal2) {
        return operation.applyAsInt(signal1, signal2);
    }
}

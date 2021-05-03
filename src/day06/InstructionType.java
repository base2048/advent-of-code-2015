package day06;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InstructionType {

    TURN_OFF(0),
    TURN_ON(1),
    TOGGLE(2);

    private final int index;
    private static Map<Integer, InstructionType> typeByIndex;

    InstructionType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static InstructionType getByIndex(int index) {
        if (typeByIndex == null)
            typeByIndex = Arrays.stream(values()).collect(Collectors.toMap(InstructionType::getIndex, Function.identity()));

        return typeByIndex.get(index);
    }

    public static InstructionType getByOrdinal(int ordinal) {
        return InstructionType.values()[ordinal];
    }
}

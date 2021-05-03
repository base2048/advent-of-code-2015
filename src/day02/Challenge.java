package day02;

import java.util.*;

public class Challenge {

    private final List<int[]> boxDimensions;

    public Challenge(List<int[]> boxDimensions) {
        this.boxDimensions = boxDimensions;
    }

    public int solvePart1() {
        return boxDimensions.stream().mapToInt(this::getPresentPaperSize).sum();
    }

    public int solvePart2() {
        return boxDimensions.stream().mapToInt(this::getPresentRibbonLength).sum();
    }

    private int getPresentPaperSize(int[] dimensions) {
        int l = dimensions[0];
        int w = dimensions[1];
        int h = dimensions[2];

        List<Integer> areas = List.of(2 * l * w, 2 * w * h, 2 * h * l);

        return areas.stream().mapToInt(Integer::intValue).sum() + areas.stream().min(Integer::compareTo).get() / 2;
    }

    private int getPresentRibbonLength(int[] dimensions) {
        return Arrays.stream(dimensions).sorted().limit(2).sum() * 2 +
                Arrays.stream(dimensions).reduce((acc, dim) -> acc * dim).orElse(0);
    }
}

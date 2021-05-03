package day06;

import java.util.*;

public class Challenge {

    private final List<int[]> instructions;
    private final int[][] grid = new int[1000][1000];

    public Challenge(List<int[]> instructions) {
        this.instructions = instructions;
    }

    public int solvePart1() {
        int[][] grid = getCopyOfGrid();
        instructions.forEach(instr -> alterGridPart1(grid, instr));
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }

    public int solvePart2() {
        int[][] grid = getCopyOfGrid();
        instructions.forEach(instr -> alterGridPart2(grid, instr));
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }

    private void alterGridPart1(int[][] grid, int[] instr) {
        for (int x = instr[1]; x < instr[3] + 1; x++) {
            for (int y = instr[2]; y < instr[4] + 1; y++) {
                InstructionType instrType = InstructionType.getByIndex(instr[0]);
                grid[x][y] = instrType == InstructionType.TOGGLE ? grid[x][y] ^ 1 : instr[0];
            }
        }
    }

    private void alterGridPart2(int[][] grid, int[] instr) {
        for (int x = instr[1]; x < instr[3] + 1; x++) {
            for (int y = instr[2]; y < instr[4] + 1; y++) {
                InstructionType instrType = InstructionType.getByIndex(instr[0]);

                grid[x][y] = switch (instrType) {
                    case TURN_OFF -> grid[x][y] == 0 ? grid[x][y] : grid[x][y] - 1;
                    case TURN_ON -> grid[x][y] + 1;
                    case TOGGLE -> grid[x][y] + 2;
                };
            }
        }
    }

    /*
     * I know this method is obsolete. Due to the fact the instance-grid never
     * gets modified one can simply declare a new grid in the solving methods.
     */
    private int[][] getCopyOfGrid() {
        return Arrays.stream(this.grid).map(int[]::clone).toArray(int[][]::new);
    }
}

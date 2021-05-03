package day18;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Challenge {

    private int steps = 100;
    private final int[][] lights;

    private final BiPredicate<Integer, Integer> isSwitchingRequired = (status, numNeighborsOn) -> {
        if (status == 0) return numNeighborsOn == 3;
        if (status == 1) return numNeighborsOn < 2 || numNeighborsOn > 3;
        return false;
    };

    public Challenge(int[][] lights) {
        this.lights = lights;
    }

    public int solvePart1() {
        Grid grid = new Grid(cloneLights(lights));
        for (int i = 0; i < steps; i++)
            grid.animate(isSwitchingRequired);

        return grid.countLightsOn();
    }

    public int solvePart2() {
        Grid grid = new Grid(cloneLights(lights));
        grid.turnEdgeLightsOn();

        for (int i = 0; i < steps; i++) {
            grid.animate(isSwitchingRequired);
            grid.turnEdgeLightsOn();
        }
        return grid.countLightsOn();
    }

    private int[][] cloneLights(int[][] lights) {
        return Arrays.stream(lights).map(int[]::clone).toArray(int[][]::new);
    }

    protected void setSteps(int steps) {
        this.steps = steps;
    }
}

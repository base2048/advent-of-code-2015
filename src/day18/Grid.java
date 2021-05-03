package day18;

import java.util.*;
import java.util.function.BiPredicate;

public class Grid {

    private final int[][] lights;

    public Grid(int[][] lights) {
        this.lights = lights;
    }

    public void animate(BiPredicate<Integer, Integer> isSwitchingRequired) {
        List<Position> switchingRequired = new ArrayList<>();

        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[0].length; y++) {
                int neighborsOn = getNumNeighborsOn(x, y);
                if (isSwitchingRequired.test(lights[x][y], neighborsOn))
                    switchingRequired.add(new Position(x, y));
            }
        }

        for (Position pos : switchingRequired)
            lights[pos.x][pos.y] ^= 1;
    }

    public int getNumNeighborsOn(int x, int y) {
        int ctr = 0;
        for (int nX = Math.max(x - 1, 0); nX < Math.min((x + 2), lights.length); nX++)
            for (int nY = Math.max(y - 1, 0); nY < Math.min((y + 2), lights[0].length); nY++)
                ctr += !(nX == x && nY == y) ? lights[nX][nY] : 0;

        return ctr;
    }

    public void turnEdgeLightsOn() {
        lights[0][0] = 1;
        lights[lights.length - 1][0] = 1;
        lights[0][lights[0].length - 1] = 1;
        lights[lights.length - 1][lights[0].length - 1] = 1;
    }

    public int countLightsOn() {
        return Arrays.stream(lights).flatMapToInt(Arrays::stream).sum();
    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

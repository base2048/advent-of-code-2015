package day01;

import java.util.List;

public class Challenge {

    private final List<Integer> directions;

    public Challenge(List<Integer> directions) {
        this.directions = directions;
    }

    public int solvePart1() {
        return directions.stream().reduce(0, Integer::sum);
    }

    public int solvePart2() {
        int ctr = 0;
        int floor = 0;

        while (floor != -1)
            floor += directions.get(ctr++);

        return ctr;
    }
}

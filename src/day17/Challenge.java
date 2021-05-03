package day17;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge {

    private int liters = 150;
    private final List<Integer> containers;

    public Challenge(List<Integer> containers) {
        this.containers = containers;
    }

    public int solvePart1() {
        return getNumberOfCombinations(containers, liters);
    }

    public int solvePart2() {
        return getContainerUsages(containers, liters, 1).stream()
                .collect(Collectors.groupingBy(u -> u, TreeMap::new, Collectors.summingInt(u -> 1)))
                .firstEntry()
                .getValue();
    }

    private int getNumberOfCombinations(List<Integer> containers, int remainingLiters) {
        if (containers.isEmpty()) return 0;
        List<Integer> trimmedContainers = containers.subList(1, containers.size());

        if (containers.get(0) == remainingLiters)
            return 1 + getNumberOfCombinations(trimmedContainers, remainingLiters);

        return getNumberOfCombinations(trimmedContainers, remainingLiters) +
                getNumberOfCombinations(trimmedContainers, remainingLiters - containers.get(0));
    }

    private List<Integer> getContainerUsages(List<Integer> containers, int remainingLiters, int containerCtr) {
        if (containers.isEmpty()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        List<Integer> trimmedContainers = containers.subList(1, containers.size());

        if (containers.get(0) == remainingLiters)
            result.add(containerCtr);

        result.addAll(getContainerUsages(trimmedContainers, remainingLiters, containerCtr));
        result.addAll(getContainerUsages(trimmedContainers, remainingLiters - containers.get(0), containerCtr + 1));

        return result;
    }

    protected void setLiters(int liters) {
        this.liters = liters;
    }
}

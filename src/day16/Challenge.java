package day16;

import java.util.*;

public class Challenge {

    private final List<Sue> aunts;
    private final Map<String, Integer> ticker;

    public Challenge(Parser.Dataset data) {
        this.aunts = data.aunts;
        this.ticker = data.ticker;
    }

    public int solvePart1() {
        return aunts.stream()
                .filter(sue -> sue.getNumberOfCompound().entrySet().stream()
                        .allMatch(entry -> ticker.get(entry.getKey()).equals(entry.getValue())))
                .mapToInt(Sue::getNumber)
                .findFirst()
                .orElse(0);
    }

    public int solvePart2() {
        return aunts.stream()
                .filter(sue -> sue.getNumberOfCompound().entrySet().stream().allMatch(this::isWantedSuePart2))
                .mapToInt(Sue::getNumber)
                .findFirst()
                .orElse(0);
    }

    private boolean isWantedSuePart2(Map.Entry<String, Integer> compound) {
        if (compound.getKey().equals("cats") || compound.getKey().equals("trees"))
            return compound.getValue() > ticker.get(compound.getKey());

        if (compound.getKey().equals("pomeranians") || compound.getKey().equals("goldfish"))
            return compound.getValue() < ticker.get(compound.getKey());

        return compound.getValue().equals(ticker.get(compound.getKey()));
    }
}

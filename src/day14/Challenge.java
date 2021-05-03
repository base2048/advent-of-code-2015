package day14;

import java.util.*;
import java.util.stream.*;

public class Challenge {

    private final List<Reindeer> reindeer;
    private int raceDuration = 2503;

    public Challenge(List<Reindeer> reindeer) {
        this.reindeer = reindeer;
    }

    public int solvePart1() {
        return reindeer.stream().mapToInt(this::getFLightDistance).max().orElse(0);
    }

    public int solvePart2() {
        /*
         * getHighScore() calculates high score directly
         * getScoreboard() builds up a score board, high score mus be extracted afterwards
         */
        final boolean SHALL_CALCULATE_HIGH_SCORE_DIRECTLY = false;

        return SHALL_CALCULATE_HIGH_SCORE_DIRECTLY
                ? getHighScore()
                : getScoreboard().values().stream().reduce(0, Math::max);
    }

    private int getFLightDistance(Reindeer reindeer) {
        return getFLightDistance(reindeer, raceDuration);
    }

    private int getFLightDistance(Reindeer reindeer, int timeStamp) {
        int unit = reindeer.getFlightTime() + reindeer.getRestTime();
        int flightSeconds = (timeStamp / unit) * reindeer.getFlightTime() +
                Math.min(timeStamp % unit, reindeer.getFlightTime());

        return flightSeconds * reindeer.getSpeed();
    }

    private int getHighScore() {
        return IntStream.rangeClosed(1, raceDuration).mapToObj(timestamp ->
                reindeer.stream()
                        .collect(Collectors.groupingBy(
                                r -> getFLightDistance(r, timestamp),
                                TreeMap::new,
                                Collectors.mapping(Reindeer::getName, Collectors.toList())))
                        .lastEntry()
                        .getValue())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(r -> r, TreeMap::new, Collectors.summingInt(r -> 1)))
                .lastEntry()
                .getValue();
    }

    private Map<String, Integer> getScoreboard() {
        Map<String, Integer> scoreboard = new HashMap<>();

        IntStream.rangeClosed(1, raceDuration).forEach(timestamp ->
                reindeer.stream()
                        .collect(Collectors.groupingBy(
                                r -> getFLightDistance(r, timestamp),
                                TreeMap::new,
                                Collectors.mapping(Reindeer::getName, Collectors.toList())))
                        .lastEntry()
                        .getValue()
                        .forEach(name -> scoreboard.merge(name, 1, Integer::sum)));

        return scoreboard;
    }

    protected void setRaceDuration(int raceDuration) {
        this.raceDuration = raceDuration;
    }
}

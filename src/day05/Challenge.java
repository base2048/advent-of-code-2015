package day05;

import java.util.*;
import java.util.function.Predicate;

public class Challenge {

    private final List<String> naughtyOrNice;

    public Challenge(List<String> naughtyOrNice) {
        this.naughtyOrNice = naughtyOrNice;
    }

    public int solvePart1() {
        Predicate<String> validator = buildValidatorPart1();
        return (int) naughtyOrNice.stream().filter(validator).count();
    }

    public int solvePart2() {
        Predicate<String> validator = buildValidatorPart2();
        return (int) naughtyOrNice.stream().filter(validator).count();
    }

    private Predicate<String> buildValidatorPart1() {
        Predicate<String> validator = $ -> true;
        return validator.and(this::doesNotContain).and(this::doesContainVowels).and(this::doesAppearTwiceConsecutively);
    }

    private Predicate<String> buildValidatorPart2() {
        Predicate<String> validator = $ -> true;
        return validator.and(this::doesContainPairTwice).and(this::doesAppearTwiceWithOneBetween);
    }

    private boolean doesNotContain(String string) {
        List<String> mustNotContain = List.of("ab", "cd", "pq", "xy");
        return mustNotContain.stream().noneMatch(string::contains);
    }

    private boolean doesContainVowels(String string) {
        return string.replaceAll("[^aeiou]", "").length() >= 3;
    }

    private boolean doesAppearTwiceConsecutively(String string) {
        for (int i = 0; i < string.length() - 1; i++)
            if (string.charAt(i) == string.charAt(i + 1)) return true;

        return false;
    }

    private boolean doesContainPairTwice(String string) {
        for (int i = 0; i < string.length() - 2; i++) {
            String pair = string.substring(i, i + 2);
            if (string.substring(i + 2).contains(pair)) return true;
        }
        return false;
    }

    private boolean doesAppearTwiceWithOneBetween(String string) {
        for (int i = 0; i < string.length() - 2; i++) {
            char candidate = string.charAt(i);
            if (string.charAt(i + 2) == candidate) return true;
        }
        return false;
    }
}

package day11;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Challenge {

    private final String currentPassword;
    private final Pattern mustNotContainPAT = Pattern.compile("[ilo]");
    private final Pattern pairPAT = Pattern.compile("(.)\\1");

    public Challenge(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String solvePart1() {
        return getNextValidPassword(currentPassword);
    }

    public String solvePart2() {
        return getNextValidPassword(solvePart1());
    }

    private String getNextValidPassword(String password) {
        do password = getNextCombination(password);
        while (!buildValidator().test(password));
        return password;
    }

    private String getNextCombination(String password) {
        int[] pw = password.chars().map(c -> c - 'a').toArray();
        int i = pw.length - 1;
        int next;

        do pw[i] = next = (pw[i--] + 1) % 26;
        while (next == 0 && i >= 0);

        String carry = pw[0] == 0 && i < 0 ? "a" : "";
        return Arrays.stream(pw)
                .mapToObj(v -> String.valueOf((char) (v + 'a')))
                .collect(Collectors.collectingAndThen(Collectors.joining(), p -> carry + p));
    }

    private Predicate<String> buildValidator() {
        Predicate<String> validator = $ -> true;
        return validator.and(this::doesNotContain).and(this::doesIncludeIncreasingStraight).and(this::doesContainTwoDifferentPairs);
    }

    private boolean doesNotContain(String string) {
        return !mustNotContainPAT.matcher(string).find();
    }

    private boolean doesIncludeIncreasingStraight(String string) {
        for (int i = 0; i < string.length() - 2; i++)
            if (string.charAt(i) == string.charAt(i + 1) - 1 &&
                    string.charAt(i + 1) == string.charAt(i + 2) - 1) return true;

        return false;
    }

    private boolean doesContainTwoDifferentPairs(String string) {
        Matcher matcher = pairPAT.matcher(string);
        String cache = "";
        while (matcher.find()) {
            if (cache.length() > 0 && !matcher.group().equals(cache)) return true;
            cache = matcher.group();
        }
        return false;
    }
}

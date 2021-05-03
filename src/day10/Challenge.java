package day10;

import java.util.regex.*;

public class Challenge {

    private final String initialValue;
    private final Pattern numbersPAT = Pattern.compile("(1+|2+|3+|4+|5+|6+|7+|8+|9+|0+)");

    public Challenge(String initialValue) {
        this.initialValue = initialValue;
    }

    public int solvePart1() {
        return playLookAndSay(initialValue, 40);
    }

    public int solvePart2() {
        return playLookAndSay(initialValue, 50);
    }

    private int playLookAndSay(String value, int rounds) {
        for (int i = 0; i < rounds; i++) {
            Matcher matcher = numbersPAT.matcher(value);
            StringBuilder sb = new StringBuilder();

            while (matcher.find()) {
                String found = matcher.group();
                sb.append(found.length()).append(found.charAt(0));
            }
            value = sb.toString();
        }
        return value.length();
    }

    protected int testFunction_playLookAndSay(String value, int rounds) {
        return playLookAndSay(value, rounds);
    }
}

package day08;

import java.util.List;

public class Challenge {

    private final List<String> literals;

    public Challenge(List<String> literals) {
        this.literals = literals;
    }

    public int solvePart1() {
        int literalCharNumbers = literals.stream().mapToInt(String::length).sum();
        int memoryCharNumbers = literals.stream()
                .mapToInt(literal -> literal
                        .replaceAll("^\\u0022|\\u0022$", "")
                        .replaceAll("\\u005c\\u0022|\\u005c\\u005c|\\u005cx[0-9,a-f]{2}", "_")
                        .length())
                .sum();
        return literalCharNumbers - memoryCharNumbers;
    }

    public int solvePart2() {
        int literalCharNumbers = literals.stream().mapToInt(String::length).sum();
        int newlyCharNumbers = literals.stream()
                .mapToInt(literal -> literal.replaceAll("\\u0022|\\u005c", "__").length() + 2)
                .sum();
        return newlyCharNumbers - literalCharNumbers;
    }
}

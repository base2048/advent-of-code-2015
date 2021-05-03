package day11;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"abcdefgh, abcdffaa", "ghijklmn, ghjaabcc", "aaaabci, aaabbcd"})
    void solvePart1(String input, String expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }
}

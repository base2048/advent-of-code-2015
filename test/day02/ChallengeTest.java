package day02;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Order(10)
    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"2x3x4, 58", "1x1x10, 43"})
    void solvePart1(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }

    @Order(20)
    @DisplayName("solvePart2")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"2x3x4, 34", "1x1x10, 14"})
    void solvePart2(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart2());
    }
}

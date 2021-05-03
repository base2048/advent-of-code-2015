package day01;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Order(10)
    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{2} {index}: {0} = {1}")
    @CsvFileSource(resources = "testData.csv")
    void solvePart1(String input, int expected, String name) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }

    @Order(20)
    @DisplayName("solvePart2")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"), 1", "()()), 5"})
    void solvePart2(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart2());
    }
}

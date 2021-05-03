package day20;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @DisplayName("solvePart1")
    @ParameterizedTest(name = "{index}")
    @CsvSource(value = {"120, 6", "150, 8", "70, 4"})
    @Order(10)
    void solvePart1(String input, int expected) {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(expected, challenge.solvePart1());
    }
}

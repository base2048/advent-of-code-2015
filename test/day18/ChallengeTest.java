package day18;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    static String input = ".#.#.#\n" +
            "...##.\n" +
            "#....#\n" +
            "..#...\n" +
            "#.#..#\n" +
            "####..";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setSteps(4);
        assertEquals(4, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setSteps(5);
        assertEquals(17, challenge.solvePart2());
    }
}

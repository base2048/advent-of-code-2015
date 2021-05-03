package day24;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    static String input = "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "7\n" +
            "8\n" +
            "9\n" +
            "10\n" +
            "11";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(99, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(44, challenge.solvePart2());
    }
}

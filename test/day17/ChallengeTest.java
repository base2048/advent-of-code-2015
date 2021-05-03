package day17;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "20\n" +
            "15\n" +
            "10\n" +
            "5\n" +
            "5";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setLiters(25);
        assertEquals(4, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setLiters(25);
        assertEquals(3, challenge.solvePart2());
    }
}

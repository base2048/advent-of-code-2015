package day14;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
            "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setRaceDuration(1000);
        assertEquals(1120, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        challenge.setRaceDuration(1000);
        assertEquals(689, challenge.solvePart2());
    }
}

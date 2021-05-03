package day15;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final String input = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n" +
            "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3";

    @Test
    @Order(10)
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(62842880, challenge.solvePart1());
    }

    @Order(20)
    @Test
    void solvePart2() {
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(57600000, challenge.solvePart2());
    }
}

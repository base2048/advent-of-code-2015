package day05;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Test
    @Order(10)
    void solvePart1() {
        String input = "ugknbfddgicrmopn\n" +
                "aaa\n" +
                "jchzalrnumimnmhp\n" +
                "haegwjzuvuyypxyu\n" +
                "dvszwmarrgswjxmb";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(2, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() {
        String input = "qjhvhtzxzqqjkmpb\n" +
                "xxyxx\n" +
                "uurcxstgmygtbstg\n" +
                "ieodomkazucvgmuy";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(2, challenge.solvePart2());
    }
}

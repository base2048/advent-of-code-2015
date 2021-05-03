package day19;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Test
    @Order(10)
    void solvePart1_test1() {
        String input = "H => HO\n" +
                "H => OH\n" +
                "O => HH\n" +
                "\n" +
                "HOH";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(4, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart1_test2() {
        String input = "H => HO\n" +
                "H => OH\n" +
                "O => HH\n" +
                "\n" +
                "HOHOHO";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(7, challenge.solvePart1());
    }

    @Test
    @Order(30)
    void solvePart2_test1() {
        String input = "e => H\n" +
                "e => O\n" +
                "H => HO\n" +
                "H => OH\n" +
                "O => HH\n" +
                "\n" +
                "HOH";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(3, challenge.solvePart2());
    }

    @Test
    @Order(40)
    void solvePart2_test2() {
        String input = "e => H\n" +
                "e => O\n" +
                "H => HO\n" +
                "H => OH\n" +
                "O => HH\n" +
                "\n" +
                "HOHOHO";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(6, challenge.solvePart2());
    }
}

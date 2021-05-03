package day09;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    @Test
    @Order(10)
    void solvePart1_test1() {
        String input = "A to B = 1\n" +
                "A to C = 2\n" +
                "B to C = 3";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(3, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart1_test2() {
        String input = "London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(605, challenge.solvePart1());
    }

    @Test
    @Order(30)
    void solvePart2_test1() {
        String input = "A to B = 1\n" +
                "A to C = 2\n" +
                "B to C = 3";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(5, challenge.solvePart2());
    }

    @Test
    @Order(40)
    void solvePart2_test2() {
        String input = "London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141";

        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(982, challenge.solvePart2());
    }
}

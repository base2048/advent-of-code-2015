package day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    void solvePart1() {
        Challenge challenge = new Challenge(Parser.parse("row 5, column 5"));
        assertEquals(9250759L, challenge.solvePart1());
    }
}

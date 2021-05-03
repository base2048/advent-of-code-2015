package day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    void playLookAndSay_test1() {
        String input = "1211";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(6, challenge.testFunction_playLookAndSay(input, 1));
    }

    @Test
    void playLookAndSay_test2() {
        String input = "111221";
        Challenge challenge = new Challenge(Parser.parse(input));
        assertEquals(78, challenge.testFunction_playLookAndSay(input, 10));
    }
}

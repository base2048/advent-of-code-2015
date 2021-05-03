package day21;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    final String boss = "Hit Points: 12\n" +
            "Damage: 7\n" +
            "Armor: 2";

    @Test
    void solvePart1() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(boss));
        Player player = new Player(8, 5, 5);
        assertTrue(challenge.isPlayerOneWinning(player, challenge.getBoss()));
    }
}

package day08;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChallengeTest {

    final File file = new File("./test/day08/testData.txt");

    @Test
    @Order(10)
    void solvePart1() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(12, challenge.solvePart1());
    }

    @Test
    @Order(20)
    void solvePart2() throws IOException {
        Challenge challenge = new Challenge(Parser.parse(file));
        assertEquals(19, challenge.solvePart2());
    }
}

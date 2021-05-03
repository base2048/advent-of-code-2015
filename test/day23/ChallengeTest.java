package day23;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    static String input = "inc a\n" +
            "jio a, +2\n" +
            "tpl a\n" +
            "inc a";

    @Test
    void solvePart1() {
        Computer computer = new Computer();
        Program program = new Program(Parser.parse(input));
        computer.loadProgram(program).run();
        assertEquals(2, computer.getRegister('a'));
   }
}

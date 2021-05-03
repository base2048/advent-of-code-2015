package day07;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    void solvePart1() {
        String input = "123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i";

        Map<String, Integer> expectations = new HashMap<>();

        expectations.put("d", 72);
        expectations.put("e", 507);
        expectations.put("f", 492);
        expectations.put("g", 114);
        expectations.put("h", 65412);
        expectations.put("i", 65079);
        expectations.put("x", 123);
        expectations.put("y", 456);

        Challenge challenge = new Challenge(Parser.parse(input));
        expectations.forEach((key, value) -> assertEquals(value, challenge.testMethod_getSignal(key)));
    }
}

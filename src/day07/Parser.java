package day07;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Parser {

    private static final Map<String, Wire> wireByLink = new HashMap<>();

    public static Map<String, Wire> parse(String input) {
        Arrays.stream(input.split("\n")).forEach(Parser::parseInstruction);
        return wireByLink;
    }

    public static Map<String, Wire> parse(File file) throws IOException {
        Files.readAllLines(file.toPath()).forEach(Parser::parseInstruction);
        return wireByLink;
    }

    private static void parseInstruction(String instruction) {
        String[] tokens = instruction.split(" ");
        switch (tokens.length) {
            case 3 -> parseAssign(tokens);
            case 4 -> parseNot(tokens);
            case 5 -> parseAndOrShift(tokens);
        }
    }

    private static void parseAssign(String[] tokens) {
        wireByLink.put(tokens[2], new Wire(Gate.ASSIGN, tokens[0], "0", wireByLink));
    }

    private static void parseNot(String[] tokens) {
        wireByLink.put(tokens[3], new Wire(Gate.NOT, tokens[1], "0", wireByLink));
    }

    private static void parseAndOrShift(String[] tokens) {
        wireByLink.put(tokens[4], new Wire(Gate.valueOf(tokens[1]), tokens[0], tokens[2], wireByLink));
    }
}

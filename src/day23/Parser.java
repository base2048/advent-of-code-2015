package day23;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<Instruction> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Parser::parseInstruction).collect(Collectors.toList());
    }

    public static List<Instruction> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseInstruction).collect(Collectors.toList());
    }

    private static Instruction parseInstruction(String instruction) {
        String[] tokens = instruction.split(" ");
        return switch (tokens[0]) {
            case "hlf" -> new Hlf(tokens[1].charAt(0), 0);
            case "tpl" -> new Tpl(tokens[1].charAt(0), 0);
            case "inc" -> new Inc(tokens[1].charAt(0), 0);
            case "jmp" -> new Jmp('0', Integer.parseInt(tokens[1]));
            case "jie" -> new Jie(tokens[1].charAt(0), Integer.parseInt(tokens[2]));
            case "jio" -> new Jio(tokens[1].charAt(0), Integer.parseInt(tokens[2]));
            default -> throw new IllegalStateException();
        };
    }
}

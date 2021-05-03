package day06;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern numberPAT = Pattern.compile("\\d+");

    public static List<int[]> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseInstruction).collect(Collectors.toList());
    }

    private static int[] parseInstruction(String instruction) {
        int[] instr = new int[5];

        if (instruction.startsWith("turn off")) instr[0] = 0;
        else if (instruction.startsWith("turn on")) instr[0] = 1;
        else instr[0] = 2;

        instruction = instruction.replaceAll("turn off|turn on|toggle|through|,", " ");
        Matcher matcher = numberPAT.matcher(instruction);

        for (int i = 1; i < 5; i++) {
            matcher.find();
            instr[i] = Integer.parseInt(matcher.group());
        }
        return instr;
    }
}

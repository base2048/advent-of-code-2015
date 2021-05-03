package day19;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static Object parse(String text) {
        String[] tokens = text.split("\n\n");
        return parseReplacements(tokens);
    }

    public static Object parse(File file) throws IOException {
        String[] tokens = Files.readString(file.toPath()).replaceAll("\r", "").split("\n\n");
        return parseReplacements(tokens);
    }

    private static Object parseReplacements(String[] tokens) {
        return new Object() {
            final String molecule = tokens[1];
            final List<Replacement> replacements = Arrays.stream(tokens[0].split("\n"))
                    .map(r -> r.split(" => "))
                    .map(r -> new Replacement(r[0], r[1]))
                    .collect(Collectors.toList());
        };
    }
}

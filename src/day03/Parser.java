package day03;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Character> parse(String text) {
        return text.chars()
                .mapToObj(move -> (char) move)
                .collect(Collectors.toList());
    }

    public static List<Character> parse(File file) throws IOException {
        return Files.readString(file.toPath()).chars()
                .mapToObj(move -> (char) move)
                .collect(Collectors.toList());
    }
}

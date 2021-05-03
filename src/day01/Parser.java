package day01;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parse(String text) {
        return text
                .chars()
                .mapToObj(c -> c == '(' ? 1 : -1)
                .collect(Collectors.toList());
    }

    public static List<Integer> parse(File file) throws IOException {
        return Files.readString(file.toPath())
                .chars()
                .mapToObj(c -> c == '(' ? 1 : -1)
                .collect(Collectors.toList());
    }
}

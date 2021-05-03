package day02;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    public static List<int[]> parse(String text) {
        return Arrays.stream(text.split("\n"))
                .map(dim -> Arrays.stream(dim.split("x")).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.toList());
    }

    public static List<int[]> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream()
                .map(dim -> Arrays.stream(dim.split("x")).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.toList());
    }
}

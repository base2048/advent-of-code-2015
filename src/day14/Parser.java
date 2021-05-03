package day14;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern reindeerDataPAT = Pattern.compile("^(\\w+\\b).*?(\\d+).*?(\\d+).*?(\\d+)");

    public static List<Reindeer> parse(File file) throws IOException {
        return Files.lines(file.toPath())
                .map(Parser::buildReindeer)
                .collect(Collectors.toList());
    }

    public static List<Reindeer> parse(String text) {
        return Arrays.stream(text.split("\n"))
                .map(Parser::buildReindeer)
                .collect(Collectors.toList());
    }

    private static Reindeer buildReindeer(String data) {
        Matcher matcher = reindeerDataPAT.matcher(data);
        matcher.find();
        return new Reindeer(
                matcher.group(1),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)));
    }
}

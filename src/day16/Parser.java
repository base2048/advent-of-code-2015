package day16;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern suePAT = Pattern.compile("(\\w+\\b).*?(\\d+)");

    public static Dataset parse(File file) throws IOException {
        List<Sue> aunts = Files.readAllLines(file.toPath()).stream()
                .map(Parser::parseAuntSue)
                .collect(Collectors.toList());

        Map<String, Integer> ticker = Files.readAllLines(new File("./src/day16/MFCSAM-ticker.txt").toPath()).stream()
                .map(compound -> compound.split(": "))
                .collect(Collectors.toMap(t -> t[0], t -> Integer.valueOf(t[1])));

        return new Dataset(aunts, ticker);
    }

    private static Sue parseAuntSue(String aunt) {
        Matcher matcher = suePAT.matcher(aunt);
        matcher.find();
        Sue sue = new Sue(Integer.parseInt(matcher.group(2)), new HashMap<>());

        while (matcher.find())
            sue.getNumberOfCompound().put(matcher.group(1), Integer.parseInt(matcher.group(2)));

        return sue;
    }

    protected static class Dataset {
        protected final List<Sue> aunts;
        protected final Map<String, Integer> ticker;

        private Dataset(List<Sue> aunts, Map<String, Integer> ticker) {
            this.aunts = aunts;
            this.ticker = ticker;
        }
    }
}

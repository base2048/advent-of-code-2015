package day15;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    private static final Pattern ingredientPAT =
            Pattern.compile("^(\\w+\\b).*?(-?\\d+).*?(-?\\d+).*?(-?\\d+).*?(-?\\d+).*?(-?\\d+)");

    public static List<Ingredient> parse(String text) {
        return Arrays.stream(text.split("\n")).map(Parser::parseIngredient).collect(Collectors.toList());
    }

    public static List<Ingredient> parse(File file) throws IOException {
        return Files.readAllLines(file.toPath()).stream().map(Parser::parseIngredient).collect(Collectors.toList());
    }

    private static Ingredient parseIngredient(String ingredient) {
        Matcher matcher = ingredientPAT.matcher(ingredient);
        matcher.find();
        return new Ingredient(matcher.group(1),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)),
                Integer.parseInt(matcher.group(5)),
                Integer.parseInt(matcher.group(6)));
    }
}

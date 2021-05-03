package day25;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.*;

public class Parser {

    public static int[] parse(String text) {
        return getCoordsXY(text);
    }

    public static int[] parse(File file) throws IOException {
        return getCoordsXY(Files.readString(file.toPath()));
    }

    private static int[] getCoordsXY(String instruction) {
        Matcher matcher = Pattern.compile(".*?(\\d+).*?(\\d+).*").matcher(instruction);
        matcher.find();
        return new int[]{Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1))};
    }
}

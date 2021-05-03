package day20;

import java.io.*;
import java.nio.file.Files;

public class Parser {

    public static int parse(String input) {
        return Integer.parseInt(input);
    }

    public static int parse(File file) throws IOException {
        return Integer.parseInt(Files.readString(file.toPath()).trim());
    }
}

package day04;

import java.io.*;
import java.nio.file.Files;

public class Parser {

    public static String parse(String text) {
        return text;
    }

    public static String parse(File file) throws IOException {
        return Files.readString(file.toPath()).trim();
    }
}

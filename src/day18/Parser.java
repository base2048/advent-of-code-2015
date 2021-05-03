package day18;

import java.io.*;
import java.nio.file.Files;

public class Parser {

    public static int[][] parse(String text) {
        String[] rows = text.split("\n");
        return parseLights(rows);
    }

    public static int[][] parse(File file) throws IOException {
        String[] rows = Files.readString(file.toPath()).split("\r\n");
        return parseLights(rows);
    }

    private static int[][] parseLights(String[] rows) {
        int[][] lights = new int[rows[0].length()][rows.length];

        for (int x = 0; x < rows[0].length(); x++)
            for (int y = 0; y < rows.length; y++)
                lights[x][y] = rows[y].charAt(x) == '#' ? 1 : 0;

        return lights;
    }
}

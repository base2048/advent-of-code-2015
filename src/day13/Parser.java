package day13;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Parser {

    private static final Pattern personPAT = Pattern.compile("^(\\w+\\b).*?(-?\\d+).*?(\\b\\w+)\\.$");

    public static List<Guest> parse(String text) {
        return buildGuests(Arrays.stream(text.split("\n")));
    }

    public static List<Guest> parse(File file) throws IOException {
        return buildGuests(Files.readAllLines(file.toPath()).stream());
    }

    private static List<Guest> buildGuests(Stream<String> data) {
        return data
                .map(Parser::parseGuest)
                .collect(Collectors.groupingBy(
                        GuestPartialRecord::getName,
                        Collectors.toMap(GuestPartialRecord::getNameNext, GuestPartialRecord::getUnit)))
                .entrySet().stream()
                .map(entry -> new Guest(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private static GuestPartialRecord parseGuest(String data) {
        Matcher matcher = personPAT.matcher(data.replaceAll("lose ", "-"));
        matcher.find();
        return new GuestPartialRecord(matcher.group(1), matcher.group(3), Integer.valueOf(matcher.group(2)));
    }

    private static class GuestPartialRecord {
        private final String name, nameNext;
        private final Integer unit;

        private GuestPartialRecord(String name, String nameNext, Integer unit) {
            this.name = name;
            this.nameNext = nameNext;
            this.unit = unit;
        }

        private String getName() {
            return name;
        }

        private String getNameNext() {
            return nameNext;
        }

        private Integer getUnit() {
            return unit;
        }
    }
}

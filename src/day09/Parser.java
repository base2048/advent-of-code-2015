package day09;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;

public class Parser {

    public static Map<String, Map<String, Integer>> parse(String text) {
        return buildLocationsMap(Arrays.stream(text.split("\n")));
    }

    public static Map<String, Map<String, Integer>> parse(File file) throws IOException {
        return buildLocationsMap(Files.readAllLines(file.toPath()).stream());
    }

    private static Map<String, Map<String, Integer>> buildLocationsMap(Stream<String> data) {
        return data
                .flatMap(Parser::parseLocationPair)
                .collect(Collectors.groupingBy(
                        LocationPair::getPosition,
                        Collectors.toMap(LocationPair::getTarget, LocationPair::getDistance)));
    }

    private static Stream<LocationPair> parseLocationPair(String data) {
        String[] tokens = data.replaceAll("to|=", "").split(" +");

        return Stream.of(new LocationPair(tokens[0], tokens[1], Integer.valueOf(tokens[2])),
                new LocationPair(tokens[1], tokens[0], Integer.valueOf(tokens[2])));
    }

    private static class LocationPair {
        private final String position, target;
        private final Integer distance;

        public LocationPair(String position, String target, Integer distance) {
            this.position = position;
            this.target = target;
            this.distance = distance;
        }

        private String getPosition() {
            return position;
        }

        private String getTarget() {
            return target;
        }

        private int getDistance() {
            return distance;
        }
    }
}

package day09;

import java.util.*;

public class Route {

    private int distance;
    private final ArrayDeque<String> locations;
    private final Map<String, Map<String, Integer>> locationToDistByLoc;   // <own location <target location, distance>>

    public Route(int distance, ArrayDeque<String> locations, Map<String, Map<String, Integer>> locationToDistanceByLocation) {
        this.distance = distance;
        this.locations = locations;
        this.locationToDistByLoc = locationToDistanceByLocation;
    }

    public void addLocation(String location) {
        distance += locationToDistByLoc.get(locations.getLast()).get(location);
        locations.addLast(location);
    }

    public int getDistance() {
        return distance;
    }
}

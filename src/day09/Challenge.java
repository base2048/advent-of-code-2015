package day09;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Challenge {

    private final Map<String, Map<String, Integer>> locationToDistByLoc;   // <own location <target location, distance>>

    public Challenge(Map<String, Map<String, Integer>> locationToDistanceByLocation) {
        this.locationToDistByLoc = locationToDistanceByLocation;
    }

    public int solvePart1() {
        List<Route> routes = runRoutes(new ArrayDeque<>(locationToDistByLoc.keySet()));
        return routes.stream().mapToInt(Route::getDistance).min().orElse(0);
    }

    public int solvePart2() {
        List<List<String>> routes = runRoutesOneWay(new ArrayList<>(locationToDistByLoc.keySet()), new ArrayList<>());
        return calculateDistances(routes).stream().max(Integer::compareTo).orElse(0);
    }

    /*
     * Scraping routes with the help of a Route class.
     * Calculating distances on the fly.
     */
    private List<Route> runRoutes(ArrayDeque<String> locations) {
        if (locations.size() == 1) return Collections.singletonList(new Route(0, locations, this.locationToDistByLoc));

        List<Route> routes = new ArrayList<>();
        for (String location : locations)
            runRoutes(locations.stream().filter(Predicate.not(location::equals)).collect(collectToArrayDeque()))
                    .forEach(route -> {
                        route.addLocation(location);
                        routes.add(route);
                    });

        return routes;
    }

    /*
     * Scraping routes by tree-running from bottom to top.
     * No backward recursive data collecting.
     * Distances must be calculated afterwards.
     */
    private final List<List<String>> routesOneWay = new ArrayList<>();

    private List<List<String>> runRoutesOneWay(List<String> locations, List<String> route) {
        if (locations.size() == 0) routesOneWay.add(route);

        for (String location : locations) {
            List<String> extendedRoute = new ArrayList<>(route);
            extendedRoute.add(location);

            runRoutesOneWay(
                    locations.stream().filter(Predicate.not(location::equals)).collect(Collectors.toList()),
                    extendedRoute);
        }
        return routesOneWay;
    }

    private List<Integer> calculateDistances(List<List<String>> routes) {
        List<Integer> result = new ArrayList<>();
        for (List<String> route : routes) {
            int distance = 0;
            for (int i = 0; i < route.size() - 1; i++)
                distance += getDistanceBetween(route.get(i), route.get(i + 1));

            result.add(distance);
        }
        return result;
    }

    private int getDistanceBetween(String locationA, String locationB) {
        return this.locationToDistByLoc.get(locationA).get(locationB);
    }

    private Collector<String, ArrayDeque<String>, ArrayDeque<String>> collectToArrayDeque() {
        return Collector.of(ArrayDeque::new, ArrayDeque::add, (left, right) -> { left.addAll(right); return left; });
    }
}

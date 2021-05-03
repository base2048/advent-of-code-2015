package day13;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Challenge {

    private final List<Guest> guests;

    public Challenge(List<Guest> guests) {
        this.guests = guests;
    }

    public int solvePart1() {
        return runArrangements(new ArrayDeque<>(guests)).stream()
                .mapToInt(Arrangement::closeCircle)
                .max()
                .orElse(0);
    }

    public int solvePart2() {
        return runArrangements(new ArrayDeque<>(injectSanta(this.guests))).stream()
                .mapToInt(Arrangement::closeCircle)
                .max()
                .orElse(0);
    }

    private List<Arrangement> runArrangements(ArrayDeque<Guest> guests) {
        if (guests.size() == 1) return Collections.singletonList(new Arrangement(0, guests));

        List<Arrangement> arrangements = new ArrayList<>();
        for (Guest guest : guests)
            runArrangements(guests.stream().filter(Predicate.not(guest::equals)).collect(collectToArrayDeque()))
                    .forEach(arrangement -> {
                        arrangement.addPerson(guest);
                        arrangements.add(arrangement);
                    });

        return arrangements;
    }

    private List<Guest> injectSanta(List<Guest> guests) {
        Guest santa = new Guest("Santa", new HashMap<>());
        guests.forEach(guest -> {
            santa.getHappyUnits().put(guest.getName(), 0);
            guest.getHappyUnits().put("Santa", 0);
        });
        guests.add(santa);
        return guests;
    }

    private Collector<Guest, ArrayDeque<Guest>, ArrayDeque<Guest>> collectToArrayDeque() {
        return Collector.of(ArrayDeque::new, ArrayDeque::add, (left, right) -> { left.addAll(right); return left; });
    }
}

package day07;

import java.util.*;

public class Challenge {

    private final Map<String, Wire> wireByLink;

    public Challenge(Map<String, Wire> wireByLink) {
        this.wireByLink = wireByLink;
    }

    public int solvePart1() {
        return wireByLink.get("a").getSignal();
    }

    public int solvePart2() {
        int signalWireA = wireByLink.get("a").getSignal();
        wireByLink.values().forEach(Wire::reset);

        wireByLink.get("b").setSignal(signalWireA);
        return wireByLink.get("a").getSignal();
    }

    protected int testMethod_getSignal(String wire) {
        return wireByLink.get(wire).getSignal();
    }
}

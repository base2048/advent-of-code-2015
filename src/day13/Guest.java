package day13;

import java.util.Map;

public class Guest {

    private final String name;
    private final Map<String, Integer> happyUnits;

    public Guest(String name, Map<String, Integer> happyUnitByNext) {
        this.name = name;
        this.happyUnits = happyUnitByNext;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getHappyUnits() {
        return happyUnits;
    }
}

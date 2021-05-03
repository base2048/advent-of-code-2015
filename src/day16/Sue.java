package day16;

import java.util.Map;

public class Sue {

    private final int number;
    private final Map<String, Integer> numberOfCompound;

    public Sue(int number, Map<String, Integer> numberOfCompound) {
        this.number = number;
        this.numberOfCompound = numberOfCompound;
    }

    public int getNumber() {
        return number;
    }

    public Map<String, Integer> getNumberOfCompound() {
        return numberOfCompound;
    }
}

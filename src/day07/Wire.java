package day07;

import java.util.Map;

public class Wire {

    private int signal = -1;

    private final Gate gate;
    private final String depending1;
    private final String depending2;
    private final Map<String, Wire> wiresByLink;

    public Wire(Gate gate, String depending1, String depending2, Map<String, Wire> wiresByLink) {
        this.gate = gate;
        this.depending1 = depending1;
        this.depending2 = depending2;
        this.wiresByLink = wiresByLink;
    }

    public int getSignal() {
        if (signal < 0)
            signal = gate.execute(parseDepending(depending1), parseDepending(depending2));

        return signal;
    }

    private int parseDepending(String depending) {
        try {
            return Integer.parseInt(depending);
        } catch (NumberFormatException e) {
            return wiresByLink.get(depending).getSignal();
        }
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public void reset() {
        signal = -1;
    }
}

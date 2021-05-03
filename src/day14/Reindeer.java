package day14;

public class Reindeer {

    private final String name;
    private final int speed;
    private final int flightTime;
    private final int restTime;

    public Reindeer(String name, int speed, int flightTime, int restTime) {
        this.name = name;
        this.speed = speed;
        this.flightTime = flightTime;
        this.restTime = restTime;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public int getRestTime() {
        return restTime;
    }
}

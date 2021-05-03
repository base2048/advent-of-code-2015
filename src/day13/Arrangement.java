package day13;

import java.util.*;

public class Arrangement {

    private int happiness;
    private final ArrayDeque<Guest> guests;

    public Arrangement(int happiness, ArrayDeque<Guest> guests) {
        this.happiness = happiness;
        this.guests = guests;
    }

    public void addPerson(Guest guest) {
        happiness += guest.getHappyUnits().get(guests.getFirst().getName());
        happiness += guests.getFirst().getHappyUnits().get(guest.getName());
        guests.addFirst(guest);
    }

    public int closeCircle() {
        happiness += guests.getLast().getHappyUnits().get(guests.getFirst().getName());
        happiness += guests.getFirst().getHappyUnits().get(guests.getLast().getName());
        return happiness;
    }
}

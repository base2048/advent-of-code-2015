package day22;

import java.util.*;

public class SpellsLineupGenerator {

    private int runningId = 0;
    private int currentLineupCosts;
    private final List<Spell> spells;

    public SpellsLineupGenerator(List<Spell> spells) {
        this.spells = spells;
    }

    public ArrayDeque<Spell> generate() {
        spells.forEach(Spell::reset);   // Spells are reused, so they must be reset
        ArrayDeque<Spell> lineUp = new ArrayDeque<>();
        currentLineupCosts = 0;

        /*
         * For an alternative counting approach see day 11.
         */
        int id = runningId++;
        int base = spells.size();
        do {
            Spell spell = spells.get(id % base);
            currentLineupCosts += spell.getCost();
            lineUp.push(spell);
            id = id / base - 1;
        } while (id >= 0);

        return lineUp;
    }

    public int getCurrentLineupCosts() {
        return currentLineupCosts;
    }
}

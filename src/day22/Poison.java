package day22;

public class Poison extends Spell {

    public Poison(String name, int cost, int duration) {
        super(name, cost, duration);
    }

    @Override
    public Spell cast(Wizard wizard, Player victim) {
        super.cast(wizard, victim);
        victim.removeHitPoints(3);
        return this;
    }
}

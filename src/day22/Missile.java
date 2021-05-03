package day22;

public class Missile extends Spell {

    public Missile(String name, int cost, int duration) {
        super(name, cost, duration);
    }

    @Override
    public Spell cast(Wizard wizard, Player victim) {
        super.cast(wizard, victim);
        victim.removeHitPoints(4);
        return this;
    }
}

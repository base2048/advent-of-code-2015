package day22;

public class Drain extends Spell {

    public Drain(String name, int cost, int duration) {
        super(name, cost, duration);
    }

    @Override
    public Spell cast(Wizard wizard, Player victim) {
        super.cast(wizard, victim);
        victim.removeHitPoints(2);
        wizard.addHitPoints(2);
        return this;
    }
}

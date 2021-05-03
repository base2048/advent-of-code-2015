package day22;

public class Recharge extends Spell {

    public Recharge(String name, int cost, int duration) {
        super(name, cost, duration);
    }

    @Override
    public Spell cast(Wizard wizard, Player victim) {
        super.cast(wizard, victim);
        wizard.addMana(101);
        return this;
    }
}

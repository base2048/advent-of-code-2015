package day22;

public class Shield extends Spell {

    public Shield(String name, int cost, int duration) {
        super(name, cost, duration);
    }

    @Override
    public Spell cast(Wizard wizard, Player victim) {
        super.cast(wizard, victim);
        wizard.addArmor(7);
        return this;
    }
}

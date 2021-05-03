package day22;

public abstract class Spell {

    private final String name;
    private final int cost;
    private final int duration;

    private int castsLeft;

    public Spell(String name, int cost, int duration) {
        this.name = name;
        this.cost = cost;
        this.duration = duration;
    }

    public Spell activate() {
        castsLeft = duration;
        return this;
    }

    public Spell cast(Wizard wizard, Player victim) {
        if (castsLeft == 0) throw new ArithmeticException("You can't cast spells you down own");
        castsLeft--;
        return this;
    }

    public int getCastsLeft() {
        return castsLeft;
    }

    public int getCost() {
        return cost;
    }

    public void reset() {
        castsLeft = 0;
    }
}

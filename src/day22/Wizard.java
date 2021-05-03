package day22;

import java.util.*;

public class Wizard extends Player {

    private int mana;
    private final int initialMana;
    private ArrayDeque<Spell> spellsLineup;
    private final List<Spell> activeSpells = new ArrayList<>();

    public Wizard(int points, int mana) {
        super(points, 0, 0);
        this.initialMana = this.mana = mana;
    }

    public void setSpellsLineup(ArrayDeque<Spell> spellsLineup) {
        this.spellsLineup = spellsLineup;
    }

    public void addMana(int mana) {
        this.mana += mana;
    }

    public void castActiveSpells(Player victim) {
        activeSpells.removeIf(spell -> spell.cast(this, victim).getCastsLeft() == 0);
    }

    public boolean castNextSpell(Player victim) {
        if (spellsLineup.isEmpty()) return false;
        Spell spell = spellsLineup.poll();

        if (spell.getCastsLeft() > 0) return false;
        if (spell.getCost() > mana) return false;

        mana -= spell.getCost();
        spell.activate().cast(this, victim);
        if (spell.getCastsLeft() > 0)
            activeSpells.add(spell);

        return true;
    }

    public void unCastShieldSpell() {
        this.setArmor(0);
    }

    @Override
    public Player reset() {
        super.reset();
        mana = initialMana;
        activeSpells.clear();
        return this;
    }
}

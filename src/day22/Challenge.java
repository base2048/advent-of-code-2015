package day22;

import java.util.*;

public class Challenge {

    private final Boss boss;
    private final Wizard wizard;
    private final List<Spell> spells;

    public Challenge(Parser.Dataset data) {
        this.boss = data.boss;
        this.wizard = data.wizard;
        this.spells = data.spells;
    }

    public int solvePart1() {
        return getSpellCosts(false);
    }

    public int solvePart2() {
        return getSpellCosts(true);
    }

    private int getSpellCosts(boolean isExtraDifficult) {
        /*
         * Spells are already cost sorted, so the first win is the cheapest.
         */
        SpellsLineupGenerator slg = new SpellsLineupGenerator(spells);

        do {
            wizard.reset().setAttacking(true);
            boss.reset().setAttacking(false);
            wizard.setSpellsLineup(slg.generate());
        } while (!isWizardWinning(wizard, boss, isExtraDifficult));

        return slg.getCurrentLineupCosts();
    }

    protected boolean isWizardWinning(Wizard wizard, Boss boss, boolean isExtraDifficult) {
        boolean isWizardWealthy = true;

        while (isWizardWealthy && wizard.getHitPoints() > 0 && boss.getHitPoints() > 0) {
            if (isExtraDifficult)
                wizard.removeHitPoints(1);

            wizard.castActiveSpells(boss);

            if (wizard.isAttacking()) isWizardWealthy = wizard.castNextSpell(boss);
            else wizard.removeHitPoints(Math.max(boss.getDamage() - wizard.getArmor(), 1));

            wizard.unCastShieldSpell();
            wizard.toggleAttacking();
            boss.toggleAttacking();
        }

        return isWizardWealthy && wizard.getHitPoints() > 0;
    }
}

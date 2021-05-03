package day21;

import java.util.function.*;
import java.util.stream.Collectors;

public class Challenge {

    private final Player boss;
    private final Player player;
    private final Shop shop;

    public Challenge(Parser.Dataset data) {
        this.boss = data.boss;
        this.shop = data.shop;
        this.player = new Player(100, 0, 0);
    }

    public int solvePart1() {
        return getCosts(hasToWin -> hasToWin, Math::min);
    }

    public int solvePart2() {
        return getCosts(hasToWin -> !hasToWin, Math::max);
    }

    private int getCosts(Predicate<Boolean> hasToWin, ToIntBiFunction<Integer, Integer> updateCosts) {
        /*
         * Only weapon is mandatory. To make it feasible to go into battle without armor and extra specials
         * we add blank items to the shop - since we can pick up to 2 rings we also need 2 blank rings.
         */
        shop.armor.add(new Item("No armor", 0, 0, 0));
        shop.rings.add(new Item("No damage ring", 0, 0, 0));
        shop.rings.add(new Item("No defense ring", 0, 0, 0));

        int costs = hasToWin.test(true) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (Item weapon : shop.weapons) {
            for (Item armor : shop.armor) {
                for (Item ring1 : shop.rings) {
                    for (Item ring2 : shop.rings.stream().filter(r -> !r.equals(ring1)).collect(Collectors.toList())) {
                        boss.setHitPoints(100);
                        player.setHitPoints(100);
                        player.setDamage(weapon.damage + ring1.damage + ring2.damage);
                        player.setArmor(armor.armor + ring1.armor + ring2.armor);

                        if (hasToWin.test(isPlayerOneWinning(player, boss)))
                            costs = updateCosts.applyAsInt(weapon.cost + armor.cost + ring1.cost + ring2.cost, costs);
                    }
                }
            }
        }
        return costs;
    }

    protected boolean isPlayerOneWinning(Player playerOne, Player playerTwo) {
        playerOne.setAttacking(true);
        playerTwo.setAttacking(false);

        while (playerOne.getHitPoints() > 0 && playerTwo.getHitPoints() > 0) {
            if (playerOne.isAttacking()) fight(playerOne, playerTwo);
            else fight(playerTwo, playerOne);

            playerOne.toggleAttacking();
            playerTwo.toggleAttacking();
        }
        return playerOne.getHitPoints() > 0;
    }

    private void fight(Player attacker, Player defender) {
        int damage = Math.max(attacker.getDamage() - defender.getArmor(), 1);
        defender.setHitPoints(defender.getHitPoints() - damage);
    }

    protected Player getBoss() {
        return boss;
    }
}

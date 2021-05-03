package day22;

public abstract class Player {

    private int hitPoints;
    private int damage;
    private int armor;
    private boolean isAttacking;
    private final int initialHitPoints;

    public Player(int hitPoints, int damage, int armor) {
        this.initialHitPoints = this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void addHitPoints(int hitPoints) {
        this.hitPoints += hitPoints;
    }

    public void removeHitPoints(int hitPoints) {
        this.hitPoints -= hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void addArmor(int armor) {
        this.armor += armor;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    public void toggleAttacking() {
        isAttacking = !isAttacking;
    }

    public Player reset() {
        hitPoints = initialHitPoints;
        return this;
    }
}

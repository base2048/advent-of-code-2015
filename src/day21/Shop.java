package day21;

import java.util.List;

public class Shop {

    public final List<Item> weapons, armor, rings;

    public Shop(List<Item> weapons, List<Item> armor, List<Item> rings) {
        this.weapons = weapons;
        this.armor = armor;
        this.rings = rings;
    }
}

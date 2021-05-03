package day22;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;

public class Parser {

    public static Dataset parse(File file) throws IOException {
        Boss boss = parseBoss(Files.readString(file.toPath()).replaceAll("\r", ""));
        Wizard wizard = new Wizard(50, 500);
        List<Spell> spells = getCostSortedSpells();
        return new Dataset(boss, wizard, spells);
    }

    private static Boss parseBoss(String data)  {
        Pattern bossPAT = Pattern.compile(".*?(\\d+).*?(\\d+)");
        Matcher matcher = bossPAT.matcher(data.replaceAll("[\r\n]", ""));
        matcher.find();
        return new Boss(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)));
    }

    private static List<Spell> getCostSortedSpells() {
        Spell missile = new Missile("Magic Missile", 53, 1);
        Spell drain = new Drain("Drain", 73, 1);
        Spell shield = new Shield("Shield", 113, 6);
        Spell poison = new Poison("Poison", 173, 6);
        Spell recharge = new Recharge("Recharge", 229, 5);
        return Arrays.asList(missile, drain, shield, poison, recharge);
    }

    protected static class Dataset {
        protected final Boss boss;
        protected final Wizard wizard;
        protected final List<Spell> spells;

        private Dataset(Boss boss, Wizard wizard, List<Spell> spells) {
            this.boss = boss;
            this.wizard = wizard;
            this.spells = spells;
        }
    }
}

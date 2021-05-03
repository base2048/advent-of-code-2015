package day21;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Parser {

    public static Dataset parse(String text) throws IOException {
        Player boss = parseBoss(text);
        Shop shop = parseShop();
        return new Dataset(boss, shop);
    }

    public static Dataset parse(File file) throws IOException {
        Player boss = parseBoss(Files.readString(file.toPath()).replaceAll("\r", ""));
        Shop shop = parseShop();
        return new Dataset(boss, shop);
    }

    private static Player parseBoss(String data)  {
        Pattern bossPAT = Pattern.compile(".*?(\\d+).*?(\\d+).*?(\\d+)");
        Matcher matcher = bossPAT.matcher(data.replaceAll("[\r\n]", ""));
        matcher.find();
        return new Player(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)));
    }

    private static Shop parseShop() throws IOException {
        String[] sections = Files.readString(new File("./src/day21/shop.txt").toPath())
                .replaceAll("\r", "")
                .split("\n\n");

        List<Item> weapons = Arrays.stream(sections[0].split("\n"))
                .skip(1)
                .map(Parser::parseItems)
                .collect(Collectors.toList());

        List<Item> armor = Arrays.stream(sections[1].split("\n"))
                .skip(1)
                .map(Parser::parseItems)
                .collect(Collectors.toList());

        List<Item> rings = Arrays.stream(sections[2].split("\n"))
                .skip(1)
                .map(Parser::parseItems)
                .collect(Collectors.toList());

        return new Shop(weapons, armor, rings);
    }

    private static Item parseItems(String item) {
        Pattern itemPAT = Pattern.compile("^(.*?) *?(\\d+) *?(\\d+) *?(\\d+) *?$");
        Matcher matcher = itemPAT.matcher(item);
        matcher.find();
        return new Item(
                matcher.group(1),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3)),
                Integer.parseInt(matcher.group(4)));
    }

    protected static class Dataset {
        protected final Player boss;
        protected final Shop shop;

        private Dataset(Player boss, Shop shop) {
            this.boss = boss;
            this.shop = shop;
        }
    }
}

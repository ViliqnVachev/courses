package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Hero> heroes = new LinkedHashMap<>();

    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        String line;

        while (true) {
            line = reader.readLine();
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            String[] arguments = Arrays.stream(tokens).skip(1).toArray(String[]::new);

            switch (command) {
                case "Hero":
                    writer.writeLine(createHero(arguments));
                    break;

                case "Item":
                    writer.writeLine(createItem(arguments));
                    break;

                case "Recipe":
                    writer.writeLine(createRecipe(arguments));
                    break;

                case "Inspect":
                    writer.writeLine(inspect(arguments));
                    break;

                case "Quit":
                    writer.writeLine(quit());
                    return;
            }
        }
    }

    private static String quit() {
        //1. {heroType}: {heroName}
        //###HitPoints: {hitpoints}
        //###Damage: {damage}
        //###Strength: {strength}
        //###Agility: {agility}
        //###Intelligence: {intelligence}
        StringBuilder sb = new StringBuilder();
        final int[] index = {1};

        heroes.values().stream().sorted((h1, h2) -> {
            long comp1 = h1.getStrength() + h1.getAgility() + h1.getIntelligence();
            long comp2 = h2.getStrength() + h2.getAgility() + h2.getIntelligence();

            if (Long.compare(comp2, comp1) != 0) {
                return Long.compare(comp2, comp1);
            }
            long com1 = h1.getHitPoints() + h1.getDamage();
            long com2 = h2.getHitPoints() + h2.getDamage();

            return Long.compare(com2, com1);
        }).forEach(h -> {
            String items = h.getItems().size() == 0 ?
                    "None" :
                    h.getItems()
                            .stream()
                            .map(Item::getName)
                            .collect(Collectors.joining(", "));

            sb.append(String.format("%d. %s: %s", index[0]++, h.getClass().getSimpleName(), h.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("###HitPoints: %d", h.getHitPoints()))
                    .append(System.lineSeparator())
                    .append(String.format("###Damage: %d", h.getDamage()))
                    .append(System.lineSeparator())
                    .append(String.format("###Strength: %d", h.getStrength()))
                    .append(System.lineSeparator())
                    .append(String.format("###Agility: %d", h.getAgility()))
                    .append(System.lineSeparator())
                    .append(String.format("###Intelligence: %d", h.getIntelligence()))
                    .append(System.lineSeparator())
                    .append("###Items: ").append(items)
                    .append(System.lineSeparator());
        });

        return sb.toString();
    }

    private static String inspect(String[] arguments) {
        String heroName = arguments[0];
        Hero hero = heroes.get(heroName);

        return hero.toString();
    }

    private static String createRecipe(String[] arguments) {
        //•	Recipe {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus} {requiredItem1} {requiredItem2}. . .
        Recipe recipe;
        String recipeName = arguments[0];
        String heroName = arguments[1];
        int strengthBonus = Integer.parseInt(arguments[2]);
        int agilityBonus = Integer.parseInt(arguments[3]);
        int intelligenceBonus = Integer.parseInt(arguments[4]);
        int hitPointsBonus = Integer.parseInt(arguments[5]);
        int damageBonus = Integer.parseInt(arguments[6]);

        List<String> requiredItems = Arrays.stream(arguments).skip(7).collect(Collectors.toList());

        recipe = new RecipeItem(recipeName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
        Hero hero = heroes.get(heroName);
        hero.addRecipe(recipe);

        return String.format("Added recipe - %s to Hero - %s", recipeName, heroName);

    }

    private static String createItem(String[] arguments) {
        //•	Item {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus}
        Item item;
        String itemName = arguments[0];
        String heroName = arguments[1];
        int strengthBonus = Integer.parseInt(arguments[2]);
        int agilityBonus = Integer.parseInt(arguments[3]);
        int intelligenceBonus = Integer.parseInt(arguments[4]);
        int hitPointsBonus = Integer.parseInt(arguments[5]);
        int damageBonus = Integer.parseInt(arguments[6]);

        item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        Hero hero = heroes.get(heroName);
        hero.addItem(item);

        return String.format("Added item - %s to Hero - %s", itemName, heroName);

        //Added item - {itemName} to Hero - {heroName}
    }

    private static String createHero(String[] arguments) {
        Hero hero = null;
        String heroName = arguments[0];
        String heroType = arguments[1];

        switch (heroType) {
            case "Barbarian":
                hero = new Barbarian(heroName);
                break;

            case "Assassin":
                hero = new Assassin(heroName);
                break;

            case "Wizard":
                hero = new Wizard(heroName);
                break;
        }
        heroes.put(heroName, hero);
        return String.format("Created %s - %s", hero.getClass().getSimpleName(), hero.getName());
    }
}
package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static Map<String, Hero> heroes = new LinkedHashMap<>();

    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];

            String[] arguments = Arrays.stream(tokens).skip(1).toArray(String[]::new);

            String result = commandMethod(command, arguments);
            writer.writeLine(result);

            if ("Quit" .equals(command)) {

                break;

            }
        }
    }

    private static String commandMethod(String command, String[] arguments) {
        Hero hero;
        Item item;
        Recipe recipe;

        switch (command) {
            case "Hero":
                hero = createHero(arguments[0], arguments[1]);
                //Created Barbarian - Ivan;
                return String.format("Created %s - %s", arguments[1], arguments[0]);
            case "Item":
                item = createItem(arguments);
                hero = heroes.get(arguments[1]);
                hero.addItem(item);
                return String.format("Added item - %s to Hero - %s", item.getName(), hero.getName());
            case "Recipe":
                recipe = createRecipe(arguments);
                hero = heroes.get(arguments[1]);
                hero.addRecipe(recipe);
                return String.format("Added recipe - %s to Hero - %s", recipe.getName(), hero.getName());
            case "Inspect":
                hero = heroes.get(arguments[0]);
                return hero.toString();

            case "Quit":
                return heroesInfo();

        }
        return null;
    }

    private static String heroesInfo() {
        StringBuilder hero = new StringBuilder();
        final int[] index = {1};
        heroes.values().stream().sorted((h1, h2) -> {
            long compSum1 = h1.getStrength() + h1.getAgility() + h1.getIntelligence();
            long compSum2 = h2.getStrength() + h2.getAgility() + h2.getIntelligence();

            if (Long.compare(compSum2, compSum1) != 0) {
                return Long.compare(compSum2, compSum1);
            }
            long compSum12 = h1.getHitPoints() + h1.getDamage();
            long compSum22 = h2.getHitPoints() + h2.getDamage();
            return Long.compare(compSum22, compSum12);
        }).forEach(h -> {
            String items = h.getItems().size() == 0 ?
                    "None" :
                    h.getItems()
                            .stream()
                            .map(Item::getName)
                            .collect(Collectors.joining(", "));

            hero.append(String.format("%d. %s: %s", index[0]++, h.getClass().getSimpleName(), h.getName()))
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
                    .append(String.format("###Items: %s", items))
                    .append(System.lineSeparator());

        });
        return hero.toString().trim();
    }

    private static Recipe createRecipe(String[] arguments) {
        List<String> temp = Arrays.stream(arguments).skip(7).collect(Collectors.toList());
        return new RecipeItem(arguments[0],
                Integer.parseInt(arguments[2]),
                Integer.parseInt(arguments[3]),
                Integer.parseInt(arguments[4]),
                Integer.parseInt(arguments[5]),
                Integer.parseInt(arguments[6]),
                temp);

    }

    private static Item createItem(String[] arguments) {
        return new CommonItem(arguments[0],
                Integer.parseInt(arguments[2]),
                Integer.parseInt(arguments[3]),
                Integer.parseInt(arguments[4]),
                Integer.parseInt(arguments[5]),
                Integer.parseInt(arguments[6]));
    }

    private static Hero createHero(String argument, String argument1) {
        Hero hero = null;
        switch (argument1) {
            case "Barbarian":
                hero = new Barbarian(argument, new HeroInventory());
                break;

            case "Assassin":
                hero = new Assassin(argument, new HeroInventory());
                break;

            case "Wizard":
                hero = new Wizard(argument, new HeroInventory());
                break;
        }
        heroes.put(argument, hero);
        return hero;
    }
}
package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }


    //Complete
    @Override
    public String getName() {
        return this.name;
    }


    //Complete
    @Override
    public long getStrength() {
        return this.inventory.getTotalStrengthBonus() + this.strength;
    }


    //Complete
    @Override
    public long getAgility() {
        return this.inventory.getTotalAgilityBonus() + this.agility;
    }


    //Complete
    @Override
    public long getIntelligence() {
        return this.inventory.getTotalIntelligenceBonus() + this.intelligence;
    }


    //Complete
    @Override
    public long getHitPoints() {
        return this.inventory.getTotalHitPointsBonus() + this.hitPoints;
    }


    //Complete
    @Override
    public long getDamage() {
        return this.inventory.getTotalDamageBonus() + this.damage;
    }


    //Complete
    @Override
    public Collection<Item> getItems() {

        Field[] fields = this.inventory.getClass().getDeclaredFields();
        Collection<Item> items = null;

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                try {
                    Map<String, Item> temp = (Map<String, Item>) field.get(this.inventory);
                    items = temp.values();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return items;
    }


    //Complete
    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    //Complete
    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {

        StringBuilder items = new StringBuilder();

        if (!this.getItems().isEmpty()) {
            for (Item item : this.getItems()) {
                items.append(item.toString());
            }
        } else {
            items.append(" None");
        }


        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", this.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", this.getIntelligence()))
                .append(System.lineSeparator())
                .append("Items:").append(items.toString());


        return sb.toString();
    }
}

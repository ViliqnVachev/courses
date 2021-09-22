package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    //COMPLETE
    @Override
    public String getName() {
        return this.name;
    }

    //COMPLETE
    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    //COMPLETE
    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    //COMPLETE
    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();

    }

    //COMPLETE
    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();

    }

    //COMPLETE
    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();

    }

    //COMPLETE
    @Override
    public Collection<Item> getItems() {
        Collection<Item> items = null;
        Field[] fields = this.inventory.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                Map<String, Item> temp;

                try {
                    temp = (Map<String, Item>) field.get(this.inventory);
                    items = temp.values();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }


    //COMPLETE
    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);

    }

    //COMPLETE
    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder hero = new StringBuilder();
        StringBuilder items = new StringBuilder();
        if (this.getItems().size() > 0) {
            for (Item item : this.getItems()) {
                items.append(System.lineSeparator())
                        .append(String.format("###Item: %s", item.getName()))
                        .append(System.lineSeparator())
                        .append(String.format("###+%d Strength", item.getStrengthBonus()))
                        .append(System.lineSeparator())
                        .append(String.format("###+%d Agility", item.getAgilityBonus()))
                        .append(System.lineSeparator())
                        .append(String.format("###+%d Intelligence", item.getIntelligenceBonus()))
                        .append(System.lineSeparator())
                        .append(String.format("###+%d HitPoints", item.getHitPointsBonus()))
                        .append(System.lineSeparator())
                        .append(String.format("###+%d Damage", item.getDamageBonus()));
            }
        } else {
            items.append(" None");
        }
        hero.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", this.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", this.getIntelligence()))
                .append(System.lineSeparator())
                .append("Items:").append(items);

        return hero.toString();
    }
}

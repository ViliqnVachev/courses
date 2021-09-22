package hell.entities.items;

import hell.interfaces.Inventory;
import hell.interfaces.Item;

public abstract class BaseItem implements Item {

    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;


    protected BaseItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }


    //Complete
    @Override
    public String getName() {
        return this.name;
    }


    //Complete
    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }


    //Complete
    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }


    //Complete
    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }


    //Complete
    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }


    //Complete
    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }
}

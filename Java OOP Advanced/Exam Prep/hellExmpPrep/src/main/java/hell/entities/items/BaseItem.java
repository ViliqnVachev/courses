package hell.entities.items;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //###Item: {item1Name}
        //###+{strengthBonus} Strength
        //###+{agilityBonus} Agility
        //###+{intelligenceBonus} Intelligence
        //###+{hitpointsBonus} HitPoints
        //###+{damageBonus} Damage

        sb.append(System.lineSeparator())
                .append(String.format("###Item: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("###+%d Strength", this.strengthBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Agility", this.agilityBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Intelligence", this.intelligenceBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d HitPoints", this.hitPointsBonus))
                .append(System.lineSeparator())
                .append(String.format("###+%d Damage", this.damageBonus));


        return sb.toString();
    }
}

package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class BaseHero implements Hero {
    private static final int START_LEVEL = 1;

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;

    private double gold;


    protected BaseHero(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setIntelligence(intelligence);
        this.level = START_LEVEL;
        this.health = this.strength * Config.HERO_HEALTH_MULTIPLIER;

        this.gold = Config.HERO_START_GOLD;

    }

    public BaseHero(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.gold = Config.HERO_START_GOLD;
        this.health = this.strength * Config.HERO_HEALTH_MULTIPLIER;
    }

    //complete
    @Override
    public int getStrength() {
        return this.strength;
    }


    //complete
    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }


    //complete
    @Override
    public int getDexterity() {
        return this.dexterity;
    }


    //complete
    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }


    //complete
    @Override
    public int getIntelligence() {
        return this.intelligence;
    }


    //complete
    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    //complete
    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }


    //complete
    @Override
    public String getName() {
        return this.name;
    }


    //complete
    @Override
    public void setName(String name) {
        this.name = name;
    }


    //complete
    @Override
    public double getHealth() {
        return this.health;
    }


    //complete
    @Override
    public double getGold() {
        return this.gold;
    }


    //complete
    @Override
    public void setHealth(double health) {
        this.health = health;
    }


    //complete
    @Override
    public void giveReward(Targetable targetable) {
        this.gold = 0;
        targetable.receiveReward(this.gold);
    }


    //complete
    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    //complete
    @Override
    public void levelUp() {

        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);

        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);

        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);

        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);

        this.level++;
    }


    //complete
    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }


    //complete
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}


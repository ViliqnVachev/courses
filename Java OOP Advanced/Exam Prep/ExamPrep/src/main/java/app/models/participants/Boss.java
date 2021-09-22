package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {
//•	Name
//•	Health
//•	Damage
//•	Gold
//•	A way of knowing if the boss is alive.

    private String name;
    private double health;
    private double gold;

    public Boss(String name) {
        this.name = name;
        this.health = Config.BOSS_HEALTH;
        this.gold = Config.BOSS_GOLD;
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
    public void takeDamage(double damage) {
        this.health -= damage;
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
    public double getDamage() {
        return Config.BOSS_DAMAGE;
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
        this.gold += 0.1 * reward;
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);

    }

    //complete
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: Boss", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f | %.2f Gold", this.getHealth(), this.getDamage(), this.getGold()))
                .append(System.lineSeparator())
                ;


        return sb.toString();
    }


}

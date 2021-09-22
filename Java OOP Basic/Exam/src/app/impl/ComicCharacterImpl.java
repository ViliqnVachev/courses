package app.impl;

import app.constants.Constants;
import app.contracts.ComicCharacter;
import app.contracts.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.matches("^[A-Za-z_]{2,12}")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_CHARACTER_NAME);
        }
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException(Constants.INVALID_ENERGY_RANGE);
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health <= 0.0) {
            throw new IllegalArgumentException(Constants.INVALID_HEALTH_RANGE);
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence <= 0.0 || intelligence > 200) {
            throw new IllegalArgumentException(Constants.INVALID_INTELLIGENCE_RANGE);
        }
        this.intelligence = intelligence;
    }

    @Override
    public boolean isContainsSuperPower(String superPowerName) {
        for (SuperPower power : powers) {
            if (power.getName().equals(superPowerName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void takeDamage(double damage) {
        // The Comic Character health is reduce from the damage
        this.health -= damage;

    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        //Changes Comic Character energy,health and inteligence with the new values but first you have to see if they are correct.
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);

    }

    @Override
    public String getName() {
        // Returns the Comic Character name
        return this.name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getIntelligence() {
        return intelligence;
    }


    @Override
    public String useSuperPowers() {
        if (this.powers.isEmpty()) {
            return String.format("%s has no super powers!", this.getName());
        } else {
            double sum = this.powers.stream().mapToDouble(SuperPower::getPowerPoints).sum();
            this.energy = (int) (this.energy + sum);
            this.health = health + (sum * 2);
            return String.format("%s used his super powers!", this.getName());
        }
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#Name: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f", this.getHealth(), this.getEnergy(), this.getIntelligence()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}

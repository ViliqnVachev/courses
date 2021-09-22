package app.impl.anti_heroes;

import app.constants.Constants;
import app.impl.ComicCharacterImpl;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    protected AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness <= 0.0) {
            throw new IllegalArgumentException(Constants.INVALID_EVILNESS);
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    //Else if the Comic Character is Anti Hero, print:
    //•	###Evilness: {special
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("###Evilness: %.2f", evilness))
                .append(System.lineSeparator());

        return sb.toString();
    }
}

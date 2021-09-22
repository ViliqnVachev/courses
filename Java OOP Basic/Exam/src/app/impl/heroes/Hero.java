package app.impl.heroes;

import app.constants.Constants;
import app.impl.ComicCharacterImpl;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    protected Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism <= 0.0) {
            throw new IllegalArgumentException(Constants.INVALID_HEROISM);
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    //If the Comic Character is Hero,print:
    //•	###Heroism: {special}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("###Heroism: %.2f", this.heroism))
                .append(System.lineSeparator());

        return sb.toString();
    }
}

package app.impl.power;

import app.constants.Constants;
import app.contracts.SuperPower;

public class Power implements SuperPower {
    private String name;
    private double points;

    public Power(String name, double points) {
        this.setName(name);
        this.setPoints(points);
    }

    private void setName(String name) {
        if (name.matches("^([@])[A-Za-z_]+(\\1)$")) {
            if (name.length() < 5) {
                throw new IllegalArgumentException(Constants.INVALID_SUPERPOWER_NAME);
            }
            this.name = name;
        } else {
            throw new IllegalArgumentException(Constants.INVALID_SUPERPOWER_NAME);
        }
    }

    private void setPoints(double points) {
        if (points <= 0.0) {
            throw new IllegalArgumentException(Constants.INVALID_SUPERPOWER_POINTS);
        }
        this.points = points;
    }

    @Override
    public String getName() {
        return this.name;
    }

    //Returns the powerPoints + Power name length divided by 2
    @Override
    public double getPowerPoints() {


        return this.points + (this.getName().length() / 2);
    }
}

package car_shop_extend;

public abstract class BaseCar implements Car {
    private static final int TIRES = 4;

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    protected BaseCar(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    protected String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s is %s and have %d horse powers", this.getModel(), this.getColor(), this.getHorsePower()))
                .append(System.lineSeparator())
                .append(String.format("This is %s produced in %s and have %d tires", this.getModel(), this.countryProduced, TIRES));

        return sb.toString();
    }
}

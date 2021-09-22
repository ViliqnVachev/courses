package shopping_spree;

public class Product {
    private static final String INVALID_NAME_EXCEPTION_MESSAGE = "Name cannot be empty";
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE = "Money cannot be negative";

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException(INVALID_MONEY_EXCEPTION_MESSAGE);
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

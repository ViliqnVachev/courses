package shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static final String INVALID_NAME_EXCEPTION_MESSAGE = "Name cannot be empty";
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE = "Money cannot be negative";
   // private static final String NOT_ENOUGTH_EXCEPTION_MESSAGE = "Money cannot be negative";

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException(INVALID_MONEY_EXCEPTION_MESSAGE);
        }
        this.money = money;
    }

    private String getName() {
        return name;
    }

    public void addProduct(Product product) {
        if (this.money - product.getCost() < 0) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        } else {
            this.bagOfProducts.add(product);
            this.money -= product.getCost();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.bagOfProducts.isEmpty()) {
            sb.append("Nothing bought");
        } else {

            for (int i = 0; i < this.bagOfProducts.size(); i++) {
                if (i == this.bagOfProducts.size() - 1) {
                    sb.append(this.bagOfProducts.get(i).getName());
                } else {
                    sb.append(this.bagOfProducts.get(i).getName()).append(", ");
                }

            }
        }
        return sb.toString();

    }

}

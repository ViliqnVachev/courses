package coffee_machine.enums;

public enum CoffeeType {
    //Espresso, Latte, Irish
    ESPRESSO, LATTE, IRISH;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

}

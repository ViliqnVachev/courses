package car_shop_extend;

public interface Rentable extends Car {

    Integer getMinRentDay();

    Double getPricePerDay();

    //+getMinRentDay(): Integer
    //+getPricePerDay(): Double
}

package car_shop_extend;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("Leon", "Gray", 110, "Spain", 3, 99.9);
        printCarInfo(seat);
        printCarInfo(audi);

    }

    private static void printCarInfo(Car car) {
        System.out.println(car.toString());
    }


}

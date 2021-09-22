package threeuple;

public class Threeuple<T, E, R> {
    T item1;
    E item2;
    R item3;

    public Threeuple(T item1, E item2, R item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.item1, this.item2, this.item3);
    }
}

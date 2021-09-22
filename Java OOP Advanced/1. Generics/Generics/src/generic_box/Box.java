package generic_box;

public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s",this.item.getClass().getName() , this.item));

        return sb.toString();
    }
}

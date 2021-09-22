package generic_scale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "c");
        System.out.println(scale.getHeavier());

        Scale<Integer> intScale = new Scale<>(5, 10);
        System.out.println(intScale.getHeavier());
    }
}

package generic_array_creator;

public class Main {
    public static void main(String[] args) {
        Integer[] strings = ArrayCreator.create(Integer.class, 10, 10);

        for (Integer string : strings) {
            System.out.println(string);
        }
    }
}

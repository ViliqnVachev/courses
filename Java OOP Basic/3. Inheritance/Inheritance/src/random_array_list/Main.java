package random_array_list;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(15);
        randomArrayList.add(16);
        randomArrayList.add(157);
        randomArrayList.add(1558);

        System.out.println(randomArrayList.getRandomElement());
    }
}

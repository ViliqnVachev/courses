package food_shortage;

public class Rebel implements Buyer {
    private String name;
    private String age;
    private String group;
    private int food;

    public Rebel(String name, String age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = FOOD;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}

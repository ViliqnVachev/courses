package food_shortage;

public class Citizen implements Identifiable, Birthtable, Buyer {
    private String name;
    private String age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, String age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = FOOD;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}

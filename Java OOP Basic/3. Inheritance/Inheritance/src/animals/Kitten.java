package animals;

public class Kitten extends Cat {
    private static final String INVALID_INPUT = "Invalid input!";
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }



    @Override
    protected String produceSound() {
        return "Miau";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s", this.produceSound());
    }
}

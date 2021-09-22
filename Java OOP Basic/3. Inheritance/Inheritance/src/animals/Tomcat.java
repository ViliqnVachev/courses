package animals;

public class Tomcat extends Cat {
    private static final String INVALID_INPUT = "Invalid input!";
    private static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }



    @Override
    protected String produceSound() {
        return "Give me one million b***h";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s", this.produceSound());
    }
}

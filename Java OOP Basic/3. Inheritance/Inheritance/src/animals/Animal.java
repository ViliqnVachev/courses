package animals;

public class Animal {
    private static final String INVALID_INPUT = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (gender == null || gender.trim().length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }

    protected String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s%n", this.name, this.age, this.gender);
    }
}

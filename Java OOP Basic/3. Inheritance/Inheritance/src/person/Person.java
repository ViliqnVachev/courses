package person;

public class Person {
    private static final String INVALID_NEGATIVE_AGE = "Age must be positive!";
    private static final String INVALID_NAME = "Name's length should not be less than 3 symbols!";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_AGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());

    }


}

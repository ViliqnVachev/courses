package person;

public class Child extends Person {
    private static final String INVALID_AGE_FOR_CHILD = "Child's age must be lesser than 15!";

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException(INVALID_AGE_FOR_CHILD);
        }
        super.setAge(age);
    }
}

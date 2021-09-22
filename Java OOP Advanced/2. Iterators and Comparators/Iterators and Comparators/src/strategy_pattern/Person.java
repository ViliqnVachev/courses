package strategy_pattern;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



   /* @Override
    public int compareTo(Person other) {
        int compareName = this.getName().compareTo(other.getName());
        if (compareName != 0) {
            return compareName;
        }

        int compareAge = this.getAge() - other.getAge();

        if (compareAge != 0) {
            return compareAge;
        }

        return this.getTown().compareTo(other.getTown());
    }*/

    // TODO: 7/16/2018

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}

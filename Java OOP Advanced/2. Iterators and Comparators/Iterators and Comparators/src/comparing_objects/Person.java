package comparing_objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private String getTown() {
        return town;
    }

    @Override
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
    }
}

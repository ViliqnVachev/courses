package equality_logic;

import java.util.Objects;

public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person o) {
        int comp = this.getName().compareTo(o.getName());

        if (comp == 0) {
            return this.getAge() - o.getAge();
        }
        return comp;
    }
@Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}

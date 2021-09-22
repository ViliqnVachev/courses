package birthday_celebrations;

import java.util.function.BiFunction;

public class Citizen implements Identifiable, Birthtable {
    private String name;
    private String age;
    private String id;
    private String birthDate;

    public Citizen(String name, String age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthDate;
    }
}

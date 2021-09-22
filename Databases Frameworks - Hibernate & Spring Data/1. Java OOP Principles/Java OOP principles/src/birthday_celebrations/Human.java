package birthday_celebrations;

public class Human implements Birthtable, Contollable {
    private String name;
    private String id;
    private String birthDate;

    public Human(String name, String id, String birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthdate() {
        return this.birthDate;
    }

    @Override
    public boolean getFakeId(String lastDigit) {
        return false;
    }
}

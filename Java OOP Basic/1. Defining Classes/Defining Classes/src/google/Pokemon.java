package google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon() {
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name == null) {
            sb.append("");
        } else {
            sb.append(String.format("%s %s", this.name, this.type)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

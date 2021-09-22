package google;

public class Children {
    private String name;
    private String birthday;

    public Children() {
    }

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name == null) {
            sb.append("");
        } else {
            sb.append(String.format("%s %s ", this.name, this.birthday)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

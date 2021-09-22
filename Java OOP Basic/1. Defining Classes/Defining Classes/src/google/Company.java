package google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company() {
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name == null) {
            sb.append("");
        } else {
            sb.append(String.format("%s %s %.2f", this.name, this.department, this.salary)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

package mankind;

public class Worker extends Human {
    private static final String INVALID_LAST_NAME_LENGTH = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY = "Expected value mismatch!Argument: %.2f";
    private static final String INVALID_WORK_HOURS_PER_DAY = "Expected value mismatch!Argument: %.2f";

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 11) {
            throw new IllegalArgumentException(String.format(INVALID_WEEK_SALARY, weekSalary));
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(String.format(INVALID_WORK_HOURS_PER_DAY, workHoursPerDay));
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.weekSalary / (this.workHoursPerDay * 7);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_LENGTH);
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName()).append(System.lineSeparator())
                .append(String.format("Week Salary: %.2f", this.getWeekSalary())).append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.getWorkHoursPerDay())).append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()));

        return sb.toString();
    }
}

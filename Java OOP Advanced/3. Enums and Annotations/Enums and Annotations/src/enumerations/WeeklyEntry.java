package enumerations;

public class WeeklyEntry {
    private Weekday weekDay;
    private String notes;

    public WeeklyEntry(String weekDay, String notes) {
        this.weekDay = Enum.valueOf(Weekday.class, weekDay.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekDay() {
        return weekDay;
    }

    @Override
    public String toString() {
        return this.weekDay.toString() + " - " + this.notes;
    }
}

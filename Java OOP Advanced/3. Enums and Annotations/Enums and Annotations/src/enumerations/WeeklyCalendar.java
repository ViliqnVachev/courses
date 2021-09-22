package enumerations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> weekly;

    public WeeklyCalendar() {
        this.weekly = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        this.weekly.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(this.weekly, new ComparatorDays());

        return this.weekly;
    }
}

package enumerations;

public class ComparatorDays implements java.util.Comparator<WeeklyEntry> {

    @Override
    public int compare(WeeklyEntry o1, WeeklyEntry o2) {
        return Integer.compare(o1.getWeekDay().ordinal(), o2.getWeekDay().ordinal());
    }
}

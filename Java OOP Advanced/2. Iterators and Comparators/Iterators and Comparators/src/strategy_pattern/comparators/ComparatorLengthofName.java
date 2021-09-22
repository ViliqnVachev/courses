package strategy_pattern.comparators;

import strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorLengthofName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int lengthOfNameComp = o1.getName().length() - o2.getName().length();
        if (lengthOfNameComp != 0) {
            return lengthOfNameComp;
        }

        return String.valueOf(o1.getName().charAt(0)).compareToIgnoreCase(String.valueOf(o2.getName().charAt(0)));
    }
}

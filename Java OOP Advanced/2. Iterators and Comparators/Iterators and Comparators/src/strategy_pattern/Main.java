package strategy_pattern;

import strategy_pattern.comparators.ComparatorByAge;
import strategy_pattern.comparators.ComparatorLengthofName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<Person> name = new TreeSet<>(new ComparatorLengthofName());
        Set<Person> age = new TreeSet<>(new ComparatorByAge());

        String[] line;
        for (int i = 0; i < n; i++) {
            line = reader.readLine().split("\\s+");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            name.add(person);
            age.add(person);
        }

        name.forEach(System.out::println);
        age.forEach(System.out::println);
    }
}

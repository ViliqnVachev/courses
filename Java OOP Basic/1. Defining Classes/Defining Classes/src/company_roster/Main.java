package company_roster;

import com.sun.java.accessibility.util.EventQueueMonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String name = line[0];
            Double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee employee = null;

            switch (line.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (line[4].matches("\\d+")) {
                        int age = Integer.parseInt(line[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = line[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = line[4];
                    int age = Integer.parseInt(line[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            employees.add(employee);

        }
        StringBuilder sb = new StringBuilder();
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(e -> {
                    sb.append(String.format("Highest Average Salary: %s",e.getKey())).append(System.lineSeparator());

                    e.getValue().stream().sorted((s1, s2) -> Double.compare(s2.getSalary(), s1.getSalary()))
                            .forEach(s -> sb.append(s).append(System.lineSeparator()));

                });
        System.out.println(sb);
    }
}

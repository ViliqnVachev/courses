import java.util.Scanner;

public class EmployeeData {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String name = s.nextLine();
        int age=Integer.parseInt(s.nextLine());
        int employeeID=Integer.parseInt(s.nextLine());
        double salary= Double.parseDouble(s.nextLine());

        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.printf("Employee ID: %08d%n",employeeID);
        System.out.printf("Salary: %.2f",salary);
    }
}

import java.util.Scanner;

public class EmployeeData {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String firstName=s.nextLine();
        String lastName=s.nextLine();
        byte age = Byte.parseByte(s.nextLine());
        String gander =s.nextLine();
        long personalID= Long.parseLong(s.nextLine());
        int empNumber=Integer.parseInt(s.nextLine());

        System.out.println("First name: "+firstName);
        System.out.println("Last name: "+lastName);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gander);
        System.out.println("Personal ID: "+personalID);
        System.out.println("Unique Employee number: "+empNumber);
}

}

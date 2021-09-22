import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int people = Integer.parseInt(s.nextLine());
        int capacity = Integer.parseInt(s.nextLine());

        int courses=(int)Math.ceil(1.0*people/capacity);
        System.out.println(courses);
    }
}

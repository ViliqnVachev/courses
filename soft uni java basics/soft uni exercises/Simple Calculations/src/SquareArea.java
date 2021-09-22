import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int a= Integer.parseInt(s.nextLine());

        int area=a*a;
        System.out.println("Square area is "+area);
    }
}

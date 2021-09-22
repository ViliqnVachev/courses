import java.util.Scanner;

public class Striangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Въведете а: ");
        int a=s.nextInt();
        System.out.println("Въведете б: ");
        int b= s.nextInt();

        int c=a*b;

        System.out.print("Лицето на правоъгълника е: ");
        System.out.print(c);

    }
}

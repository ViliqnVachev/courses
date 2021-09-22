import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Length: ");
        double lenght=Double.parseDouble(s.nextLine());
        System.out.print("Width: ");
        double width=Double.parseDouble(s.nextLine());
        System.out.print("Height: ");
        double heigth=Double.parseDouble(s.nextLine());
        double volume = (lenght*heigth*width)/3.0;
        System.out.printf("Pyramid Volume: %.2f",volume);



    }
}

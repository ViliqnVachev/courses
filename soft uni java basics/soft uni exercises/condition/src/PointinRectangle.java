import java.util.Scanner;

public class PointinRectangle {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        double x1=Double.parseDouble(s.nextLine());
        double y1=Double.parseDouble(s.nextLine());
        double x2=Double.parseDouble(s.nextLine());
        double y2=Double.parseDouble(s.nextLine());
        double x=Double.parseDouble(s.nextLine());
        double y=Double.parseDouble(s.nextLine());

        if(x>=x1&&x<=x2&&y>=y1&&y<=y2){
            System.out.println("Inside");
        }else{
            System.out.println("Outside");
        }

    }
}

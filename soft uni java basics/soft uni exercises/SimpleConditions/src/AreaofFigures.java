import java.util.Scanner;

public class AreaofFigures {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        String figures=s.nextLine();
        double area=0;
        if(figures.equals("square")){
            double a=Double.parseDouble(s.nextLine());
            area=a*a;
            //System.out.println(area);
        }else if(figures.equals("rectangle")){
            double a=Double.parseDouble(s.nextLine());
            double b=Double.parseDouble(s.nextLine());
            area=a*b;
           // System.out.println(area);
        }else if(figures.equals("circle")){
            double r=Double.parseDouble(s.nextLine());
            area=Math.PI*Math.pow(r,2);
        }else if(figures.equals("triangle")){
            double a=Double.parseDouble(s.nextLine());
            double h=Double.parseDouble(s.nextLine());
            area=(a*h)/2;
        }
        System.out.println(area);
    }
}

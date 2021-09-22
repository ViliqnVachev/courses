import java.util.Scanner;

public class dogHouse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double width = Double.parseDouble(s.nextLine());
        double hight = Double.parseDouble(s.nextLine());

        double str=width*(width/2)*2;
        double back=((width/2)*(width/2))+((width/2)*(hight-width/2)/2);
        double front=back-(width/5*width/5);

        double p=str+back+front;
        double pokriv=(width*width/2)*2;
        System.out.printf("%.2f%n",p/3);
        System.out.printf("%.2f",pokriv/5);

    }
}

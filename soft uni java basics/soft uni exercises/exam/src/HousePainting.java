import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double hightHouse=Double.parseDouble(s.nextLine());
        double widhtHouse=Double.parseDouble(s.nextLine());
        double hightRoof=Double.parseDouble(s.nextLine());

        double areaWidthHouse=widhtHouse*hightHouse;
        double areaWindows=1.5*1.5;
        double areaWidth=2*areaWidthHouse-2*areaWindows;
        double areaBack=hightHouse*hightHouse;
        double areaDoor=1.2*2;
        double AreaFrontBack=2*areaBack-areaDoor;
        double Area=areaWidth+AreaFrontBack;

        double greenPaint=Area/3.4;

        System.out.printf("%.2f%n",greenPaint);
        //roof
        double rectangleArea=2*(hightHouse*widhtHouse);
        double triangleArea=2*(hightHouse*hightRoof/2);
        double redPaint=(rectangleArea+triangleArea)/4.3;
        System.out.printf("%.2f%n",redPaint);
    }
}

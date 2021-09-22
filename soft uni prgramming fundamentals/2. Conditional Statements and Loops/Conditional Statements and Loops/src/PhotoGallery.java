import java.text.DecimalFormat;
import java.util.Scanner;

public class PhotoGallery {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int photosNumber = Integer.parseInt(s.nextLine());
        int day = Integer.parseInt(s.nextLine());
        int month = Integer.parseInt(s.nextLine());
        int year = Integer.parseInt(s.nextLine());
        int hours = Integer.parseInt(s.nextLine());
        int minutes = Integer.parseInt(s.nextLine());
        double size = Integer.parseInt(s.nextLine());
        int width = Integer.parseInt(s.nextLine());
        int height = Integer.parseInt(s.nextLine());
        DecimalFormat df = new DecimalFormat("#######.######");

        System.out.printf("Name: DSC_%04d.jpg%n", photosNumber);
        System.out.printf("Date Taken: %02d/%02d/%d %02d:%02d%n", day, month, year, hours, minutes);


        if (size>=0&&size<=999) {

            System.out.printf("Size: %sB%n",df.format(size));
        } else if (size >= 1000 && size < 999999) {
            size = size / 1000.0;
            System.out.printf("Size: %sKB%n",df.format(size));
        } else if (size >= 1000000 && size <= 999000000) {
            size = size / 1000000.0;
            System.out.printf("Size: %sMB\n",df.format(size));
        }

        if(width==height){
            System.out.printf("Resolution: %dx%d (square)%n",width,height);
        }else if(width<height){
            System.out.printf("Resolution: %dx%d (portrait)%n",width,height);
        }else if (width>height){
            System.out.printf("Resolution: %dx%d (landscape)%n",width,height);
        }

    }
}

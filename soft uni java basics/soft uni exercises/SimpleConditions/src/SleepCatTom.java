import java.util.Scanner;

public class SleepCatTom {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int off=Integer.parseInt(s.nextLine());

        int work=365-off;
        int totalPlay=work*63+off*127;
        int totalMins=30000-totalPlay;
        int hours=Math.abs(totalMins/60);
        int mins=Math.abs(totalMins%60);

        if(totalPlay<30000){
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play",hours,mins);
        }else{
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play",hours,mins);
        }

    }
}

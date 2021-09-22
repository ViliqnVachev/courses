import java.util.Scanner;

public class workHours {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int needHours = Integer.parseInt(s.nextLine());
        int workers = Integer.parseInt(s.nextLine());
        int workDays = Integer.parseInt(s.nextLine());

        int worksHours=workDays*workers*8;

        if(needHours<=worksHours){
            int hoursleft=worksHours-needHours;
            System.out.printf("%d hours left",hoursleft);
        }else{
            int overTime=needHours-worksHours;
            System.out.printf("%d overtime%nPenalties: %d",overTime,overTime*workDays);
        }

    }
}

import java.util.Scanner;

public class time {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int hour=Integer.parseInt(s.nextLine());
        int min=Integer.parseInt(s.nextLine());

        min=min+15;
        if (min>59){
            hour++;
            min=min-60;
            }
        if(hour>=24){
            hour=0;
        }
        if (min<10){
            System.out.println(hour+":0"+min);
        }else{
            System.out.println(hour+":"+min);
        }


    }
}

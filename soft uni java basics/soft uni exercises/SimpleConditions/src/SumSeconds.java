import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int firstTirme=Integer.parseInt(s.nextLine());
        int secondTirme=Integer.parseInt(s.nextLine());
        int thirdTirme=Integer.parseInt(s.nextLine());

        int totalTime=firstTirme+secondTirme+thirdTirme;
        int mins=0;
        if(totalTime>59){
            mins++;
            totalTime=totalTime-60;
        }if(totalTime>59){
            mins++;
            totalTime=totalTime-60;
        }
        if(totalTime<10){
        System.out.println(mins+":0"+totalTime);
    }else {
            System.out.println(mins+":"+totalTime);
        }
        }
}

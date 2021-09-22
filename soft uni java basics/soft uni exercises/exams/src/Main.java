import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double first =Double.parseDouble(s.nextLine());
        double second =Double.parseDouble(s.nextLine());
        double third =Double.parseDouble(s.nextLine());
        double father =Double.parseDouble(s.nextLine());

        double cleaningTime=1/(1/first+1/second+1/third);
        double restTime=cleaningTime*0.15;
        double fullTime=cleaningTime+restTime;

        if(fullTime<=father){
          double timeLeft=father-fullTime;
          timeLeft=Math.floor(timeLeft);
            System.out.printf("Cleaning time: %.2f\n" +
                    "Yes, there is a surprise - time left -> %.0f hours.",fullTime,timeLeft);
        }else{
            double  needTime=fullTime-father;
            needTime=Math.ceil(needTime);
            System.out.printf("Cleaning time: %.2f\nNo, there isn't a surprise - shortage of time -> %.0f hours.",fullTime,needTime);
        }

    }
}

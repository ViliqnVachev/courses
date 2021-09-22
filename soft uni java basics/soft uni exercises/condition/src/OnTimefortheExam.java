import java.util.Scanner;

public class OnTimefortheExam {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hourExam = Integer.parseInt(s.nextLine());
        int minutesExam = Integer.parseInt(s.nextLine());
        int hour = Integer.parseInt(s.nextLine());
        int minutes = Integer.parseInt(s.nextLine());

        String onTime="On time";
        String late="Late";
        String early="early";

        int fullMinutesExams=(hourExam*60)+minutesExam;
        int fullMinutesArrive=(hour*60)+minutes;

        if(fullMinutesExams==fullMinutesArrive){
            System.out.println(onTime);
        }else if(fullMinutesExams>fullMinutesArrive){
            int m=fullMinutesExams-fullMinutesArrive;
            if(m<=30){
                System.out.printf("%s\n%d minutes before the start",onTime,m);
            }else {
                System.out.printf("\"%s\n%d minutes after the start",onTime,m);
            }
        }else if(fullMinutesExams<fullMinutesArrive){
            int m=fullMinutesArrive-fullMinutesExams;

        }


    }
}
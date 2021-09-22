


import java.util.Scanner;

public class TheaThePhotographer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

       long numberOfPictures = Integer.parseInt(s.nextLine());
       long filterTimeSecondsPerPic =Integer.parseInt(s.nextLine());
       long filterFactor=Integer.parseInt(s.nextLine());
       long timeUpploadPerPic=Integer.parseInt(s.nextLine());

        double procent=filterFactor/100.0;
        double usefull=Math.ceil(procent*numberOfPictures);
        long fullTime=(long)numberOfPictures*filterTimeSecondsPerPic;
        long fullUpploadTime=(long)usefull*timeUpploadPerPic;
        long totalTime=(long)(fullUpploadTime+fullTime);



        long day=0;
        long hours=0;
        long minutes=0;
        long secunds=totalTime;

        secunds = totalTime % 60;
        totalTime = totalTime / 60;
        minutes =totalTime%60;
        totalTime=totalTime/60;
        hours = totalTime%24;
        totalTime=totalTime/24;
        day=totalTime%365;
        totalTime=totalTime/365;

        System.out.printf("%d:%02d:%02d:%02d",day,hours,minutes,secunds);




    }
}

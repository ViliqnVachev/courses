import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String year=console.nextLine().toLowerCase();
        int holiday=Integer.parseInt(console.nextLine());
        int weekendBornCity=Integer.parseInt(console.nextLine());

        double procent=0.15;

        if(year.equals("leap")){
            double weekend=48-weekendBornCity;
            // games
            double gamesInSofiq=weekend*(3.0/4.0);
            double gamesInBornCity=weekendBornCity;
            double gamesInHoliday=holiday*(2.0/3.0);
            double procentGames=(gamesInBornCity+gamesInHoliday+gamesInSofiq)*procent;
            double fullGames=procentGames+gamesInBornCity+gamesInHoliday+gamesInSofiq;

            System.out.printf("%.0f",Math.floor(fullGames));

        }else if(year.equals("normal")){
            double weekend=48-weekendBornCity;
            // games
            double gamesInSofiq=weekend*(3.0/4.0);
            double gamesInBornCity=weekendBornCity;
            double gamesInHoliday=holiday*(2.0/3.0);
            double fullGames=gamesInBornCity+gamesInHoliday+gamesInSofiq;

            System.out.printf("%.0f",Math.floor(fullGames));
        }

    }
}

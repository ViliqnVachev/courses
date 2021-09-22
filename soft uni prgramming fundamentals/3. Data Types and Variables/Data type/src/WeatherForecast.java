import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String number = s.nextLine();

        try {
            byte a = Byte.parseByte(number);
            System.out.println("Sunny");

        } catch (Exception ex) {

           try {
            int a = Integer.parseInt(number);
            System.out.println("Cloudy");
        } catch (Exception ex2) {


        try

        {
            long a = Long.parseLong(number);
            System.out.println("Windy");
        } catch (Exception ex3) {
        try

        {
            double a = Double.parseDouble(number);
            System.out.println("Rainy");
        } catch (Exception ex4)

        {
    }
}
}
}
}
}

import java.util.Scanner;

public class NeighbourWars {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int peshosDamages = Integer.parseInt(s.nextLine());
        int goshosDamages = Integer.parseInt(s.nextLine());

        int healthPesho = 100;
        int healthgosho = 100;

        int count = 0;

        while (healthgosho > 0 && healthPesho > 0) {
            count++;
            if (count % 2 == 1) {
                healthgosho = healthgosho - peshosDamages;
                if (healthgosho > 0) {
                    System.out.print("Pesho used Roundhouse kick and reduced");
                    System.out.printf(" Gosho to %d health.\n", healthgosho);

                }
                }

                else {
                    healthPesho = healthPesho - goshosDamages;
                    if (healthPesho > 0) {
                        System.out.print("Gosho used Thunderous fist and reduced");
                        System.out.printf(" Pesho to %d health.\n", healthPesho);
                    }
                }

                if (count % 3 == 0 && healthgosho>0&& healthPesho>0) {
                    healthPesho += 10;
                    healthgosho += 10;
                }
            }
            if(count%2==0){
                System.out.printf("Gosho won in %dth round.", count);
            }else{
                System.out.printf("Pesho won in %dth round.", count);
            }
        }
    }





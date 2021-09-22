import java.util.Scanner;

public class VaporStore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double budget = Double.parseDouble(s.nextLine());

        double priceGame = 0.0;
        double totalPrice = 0.0;
        boolean isTrue = true;
        double count = budget;

        while (isTrue) {

            String comannd = s.nextLine().toLowerCase();


            if (comannd.equals("game time")) {
                isTrue = false;
            }


            else {

                if (comannd.equals("outfall 4")) {

                    priceGame = 39.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought OutFall 4");
                        totalPrice += priceGame;
                        count = count - priceGame;
                    }
                }



                else if (comannd.equals("cs: og")) {
                    priceGame = 15.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought CS: OG");
                        totalPrice += priceGame;
                        count = count - totalPrice;
                    }

                }


                else if (comannd.equals("zplinter zell")) {
                    priceGame = 19.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Zplinter Zell");
                        totalPrice += priceGame;
                        count = count - priceGame;
                    }

                }


                else if (comannd.equals("honored 2")) {
                    priceGame = 59.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Honored 2");
                        totalPrice += priceGame;
                        count = count - priceGame;
                    }

                }


                else if (comannd.equals("roverwatch")) {
                    priceGame = 29.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch");
                        totalPrice += priceGame;
                        count = count - priceGame;
                    }

                }



                else if (comannd.equals("roverwatch origins edition")) {
                    priceGame = 39.99;
                    if (priceGame > count) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch Origins Edition");
                        totalPrice += priceGame;
                        count = count - priceGame;
                    }

                }

                else {
                    System.out.println("Not Found");
                }

            }




            if (count <= 0) {
                System.out.println("Out of money!");
                isTrue = false;
            }
        }


        if (budget > totalPrice) {
            double save = budget - totalPrice;
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalPrice, save);
        }
    }
}



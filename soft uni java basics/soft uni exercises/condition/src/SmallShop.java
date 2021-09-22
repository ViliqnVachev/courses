import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String product=s.nextLine().toLowerCase();
        String town=s.nextLine().toLowerCase();
        double kol=Double.parseDouble(s.nextLine());

        double price=-1;
        double totalPrice=-1;
        if(town.equals("sofia")){
            if(product.equals("coffee")){
                price=0.50;
            }else if(product.equals("water")){
                price=0.80;
            }else if(product.equals("beer")){
                price=1.20;
            }else if(product.equals("sweets")){
                price=1.45;
            }else if(product.equals("peanuts")){
                price=1.60;
            }
        }else if(town.equals("plovdiv")){
            if(product.equals("coffee")){
                price=0.40;
            }else if(product.equals("water")){
                price=0.70;
            }else if(product.equals("beer")){
                price=1.15;
            }else if(product.equals("sweets")){
                price=1.30;
            }else if(product.equals("peanuts")){
                price=1.50;
            }
        }else if(town.equals("varna")){
            if(product.equals("coffee")){
                price=0.45;
            }else if(product.equals("water")){
                price=0.70;
            }else if(product.equals("beer")){
                price=1.10;
            }else if(product.equals("sweets")){
                price=1.35;
            }else if(product.equals("peanuts")){
                price=1.55;
            }
        }
        totalPrice=price*kol;
        System.out.println(totalPrice);
    }
}

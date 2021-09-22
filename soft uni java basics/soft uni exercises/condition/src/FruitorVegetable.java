import java.util.Scanner;

public class FruitorVegetable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String intput=s.nextLine().toLowerCase();

        if(intput.equals("banana")||intput.equals("apple")||intput.equals("kiwi")
                ||intput.equals("cherry")||intput.equals("lemon")||intput.equals("grapes")){
            System.out.println("fruit");
        }else if(intput.equals("tomato")||intput.equals("cucumber")||intput.equals("pepper")
                ||intput.equals("carrot")){
            System.out.println("vegetable");
        }else{
            System.out.println("unknown");
        }

    }
}

import java.util.Scanner;

public class WordInPlural {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String noun=s.nextLine();

        if(noun.endsWith("y")){
            noun=noun.replace(noun.substring(noun.length()-1),"ies");

        }else if(noun.endsWith("o")||noun.endsWith("x")||noun.endsWith("s")||noun.endsWith("z")||noun.endsWith("ch")||noun.endsWith("sh")){
            noun=noun+"es";
        }else{
            noun=noun+"s";
        }
        System.out.println(noun);
    }
}

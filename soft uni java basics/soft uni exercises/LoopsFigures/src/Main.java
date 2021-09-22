import javafx.beans.binding.StringBinding;

public class Main {

    public static void main(String[] args) {
        int n = 10;

        for (int i = 0; i <n ; i++) {
            System.out.println(repeatStr(n,"*"));

        }
    }
  public static String repeatStr (int count, String text){
        StringBuilder sb= new StringBuilder();
      for (int i = 0; i < count ; i++) {
          sb.append(text);

      }
      return sb.toString();
  }
}



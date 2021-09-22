package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField num1;
    public TextField num2;
    public TextField num3;

    public void calculate(ActionEvent actionEvent) {
        try{
        double num1=Double.parseDouble(this.num1.getText());
        double num2=Double.parseDouble(this.num2.getText());

        double num3=num1+num2;
        this.num3.setText(String.valueOf(num3));
    }catch (Exception e ) {
            this.num3.setText("Грешка! ");

        }
        }
}

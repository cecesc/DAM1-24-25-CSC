/*Crear una ventana con dos campos de texto y un botón que, al hacer clic,
muestre la suma de los números ingresados en un tercer campo de texto o en una
etiqueta */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo3 extends Application {
    TextField num1 = new TextField("Escribe el primer número");
    TextField num2 = new TextField("Escribe el segundo número");
    Button btnSumar = new Button("Sumar");
    Label lblResultado = new Label();

    public static void main(String[] args) {
        launch();
    }

    public void sumar() {

        int resultado;
        int n1 = 0, n2 = 0;
        try {
            n1 = Integer.parseInt(num1.getText());
            n2 = Integer.parseInt(num2.getText());
            resultado = n1 + n2;
            lblResultado.setText(String.valueOf(resultado));
        } catch (Exception ex) {
            lblResultado.setText("ERROR: Algún operando no es un número");
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        num1.setOnKeyTyped(e -> sumar());
        num2.setOnKeyTyped(e -> sumar());

        btnSumar.setOnAction(e -> sumar());

        VBox vbox = new VBox(num1, num2, btnSumar, lblResultado);

        Scene scene = new Scene(vbox, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

}

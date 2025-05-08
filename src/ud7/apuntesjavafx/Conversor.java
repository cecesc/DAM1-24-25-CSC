package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Conversor extends Application {
    TextField txt = new TextField("Introduce la cantidad");
    Button btnConvertirE = new Button("Convertir a EUR");
    Button btnConvertirR = new Button("Convertir a RUPIAS");
    Label lblResultado = new Label();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        btnConvertirE.setOnAction(e -> convertirAE());
        btnConvertirR.setOnAction(e -> convertirAR());

        VBox vbox = new VBox(txt, btnConvertirE, btnConvertirR, lblResultado);
        Scene scene = new Scene(vbox, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Conversor RUPIAS - EUROS");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void convertirAE() {
        try {
            double rupias = Double.parseDouble(txt.getText());
            double euros = rupias / 16.0;
            lblResultado.setText(String.format("%.2f Rupias de Maldivas son %.2f EUR", rupias, euros));
        } catch (NumberFormatException e) {
            lblResultado.setText("ERROR: Introduce un número válido");
        }
    }

    public void convertirAR() {
        try {
            double euros = Double.parseDouble(txt.getText());
            double rupias = euros * 16.0;
            lblResultado.setText(String.format("%.2f Euros son %.2f Rupias de Maldivas", euros, rupias));
        } catch (NumberFormatException e) {
            lblResultado.setText("ERROR: Introduce un número válido");
        }
    }

}

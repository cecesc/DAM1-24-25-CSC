package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConversionMoneda extends Application {
    TextField txtMvr = new TextField("Introduce cantidad en MVR");
    Button btnConvertir = new Button("Convertir a EUR");
    Label lblResultado = new Label();

    public static void main(String[] args) {
        launch();
    }

    public void convertir() {
        try {
            double mvr = Double.parseDouble(txtMvr.getText());
            double euros = mvr / 16.0;
            lblResultado.setText(String.format("%.2f MVR son %.2f EUR", mvr, euros));
        } catch (NumberFormatException e) {
            lblResultado.setText("ERROR: Introduce un número válido");
        }
    }

    @Override
    public void start(Stage stage) {
        btnConvertir.setOnAction(e -> convertir());
        txtMvr.setOnAction(e -> convertir()); // permite pulsar Enter para convertir

        VBox vbox = new VBox(txtMvr, btnConvertir, lblResultado);
        Scene scene = new Scene(vbox, 300, 150);

        stage.setScene(scene);
        stage.setTitle("Conversor MVR a EUR");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
}

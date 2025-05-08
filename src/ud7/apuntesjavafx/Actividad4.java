package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actividad4 extends Application {
    TextField txtColor = new TextField("Escribe un color");
    Button btnCambiar = new Button("Cambiar color");
    VBox vbox = new VBox(txtColor, btnCambiar);

    public static void main(String[] args) {
        launch();
    }

    public void cambiarColor() {
        String color = txtColor.getText();
        try {
            vbox.setStyle("-fx-background-color: " + color + ";");
        } catch (Exception ex) {
            System.out.println("Color no válido");
        }
    }

    @Override
    public void start(Stage stage) {
        btnCambiar.setOnAction(e -> cambiarColor());
        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Cambio de Color");
        stage.show();
    }
}
 
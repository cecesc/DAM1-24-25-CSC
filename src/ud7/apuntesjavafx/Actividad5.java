package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actividad5 extends Application {
    ComboBox<String> comboColores = new ComboBox<>();
    VBox vbox = new VBox(comboColores);

    public static void main(String[] args) {
        launch();
    }

    public void cambiarColor() {
        String color = comboColores.getValue();
        if (color != null) {
            vbox.setStyle("-fx-background-color: " + color + ";");
        }
    }

    @Override
    public void start(Stage stage) {
        comboColores.getItems().addAll("red", "green", "blue", "yellow", "pink");
        comboColores.setOnAction(e -> cambiarColor());

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Color con ComboBox");
        stage.show();
    }
}

/*Crear una ventana con una lista desplegable de colores
(ComboBox) y un botón que, al hacer clic, cambie el color de fondo de la ventana al color
seleccionado en la lista desplegable.
Para prescindir del botón y cambiar el color con sólo seleccionarlo en el desplegable,
investiga el evento onAction del ComboBox que se dispara al modificar la propiedad
value. */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo5_ColorCombo extends Application {
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

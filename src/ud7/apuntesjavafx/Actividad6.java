package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actividad6 extends Application {
    TextArea area = new TextArea();
    TextField campo = new TextField("Escribe aquí");
    Button btnAgregar = new Button("Agregar texto");

    public static void main(String[] args) {
        launch();
    }

    public void agregarTexto() {
        String texto = campo.getText();
        if (!texto.isBlank()) {
            area.appendText(texto + "\n");
            campo.clear();
        }
    }

    @Override
    public void start(Stage stage) {
        btnAgregar.setOnAction(e -> agregarTexto());

        VBox vbox = new VBox(campo, btnAgregar, area);
        Scene scene = new Scene(vbox, 300, 200);

        stage.setScene(scene);
        stage.setTitle("Agregar a TextArea");
        stage.show();
    }
}

/*Crea una aplicación que utilice DialogPane para mostrar varios cuadros de diálogo con
diferentes configuraciones.. */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ejemplo14_DialogPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Mostrar Diálogo");

        btn.setOnAction(e -> {
            // Crear un cuadro de diálogo de información
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cuadro de Diálogo de Información");
            alert.setHeaderText("Información Importante");
            alert.setContentText("Este es un cuadro de diálogo de información.");

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: lightblue; -fx-font-size: 14px;");

            alert.showAndWait();
        });

        // Crear el layout principal
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Uso de DialogPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

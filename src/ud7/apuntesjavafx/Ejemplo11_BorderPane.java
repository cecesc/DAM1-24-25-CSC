package ud7.apuntesjavafx;

import com.mysql.cj.protocol.a.PacketSplitter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ejemplo11_BorderPane extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuItem menRojo = new Menu("Rojo");
        menRojo.setOnAction(E -> System.out.println("Rojo"));
        MenuItem menVerde = new Menu("Verde");
        MenuItem menAzul = new Menu("Azul");

        Menu menColores = new Menu("Colores");
        menColores.getItems().addAll(menRojo, menVerde, menAzul);

        MenuBar menuBar = new MenuBar(menColores);
        Pane panelCentarl = new Pane(label);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(panelCentarl);

menRojo.setOnAction(e -> borderPane.setStyle("-fx-background-color:"););

        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane con Menú y Colores de fondo");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}

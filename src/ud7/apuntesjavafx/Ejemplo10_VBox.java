/*Crea una aplicación que contenga un VBox con tres botones, cada uno de ellos con un
texto diferente (por ejemplo, "Botón 1", "Botón 2" y "Botón 3"). Al hacer clic en cada botón,
se debe mostrar un mensaje en la consola que indique qué botón ha sido pulsado. */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo10_VBox extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Botón 1");
        Button btn2 = new Button("Botón 2");
        Button btn3 = new Button("Botón 3");
        VBox vbox = new VBox(btn1, btn2, btn3);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Vbox");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Has pulsado el botón 1");
            }
        });

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Has pulsado el botón 2");
            }
        });

        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Has pulsado el botón 3");
            }
        });

    }

}

/*Crea una aplicación que contenga un GridPane con varios botones. Los botones deben
estar distribuidos en el GridPane de manera que formen una cuadrícula. Al hacer clic en
cada botón, se debe mostrar un mensaje en la consola que indique qué botón ha sido
pulsado y en qué posición se encuentra dentro del GridPane.
 */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejemplo13_GridPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Crear botones y asignarles posiciones en el GridPane
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Button button = new Button("Botón " + (fila * 3 + columna + 1));
                final int FL = fila;
                final int COLUM = columna;

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Botón en posición (" + FL + ", " + COLUM + ") ha sido pulsado");
                    }
                });

                gridPane.add(button, columna, fila);
            }
        }

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("GridPane con Botones");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

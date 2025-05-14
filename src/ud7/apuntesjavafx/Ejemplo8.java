/*Actividad 8. Crear una ventana que muestre un tablero de ajedrez, es decir una
cuadrícula de 8 x 8 “casillas” blancas y “negras” cuadradas.
 */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ejemplo8 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        double size = 60;

        // Crear las casillas del tablero de ajedrez (8x8)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Crear un rectángulo para cada casilla
                Rectangle square = new Rectangle(size, size);
                // Alternar entre blanco y negro
                if ((i + j) % 2 == 0) {
                    square.setFill(Color.WHITE);
                } else {
                    square.setFill(Color.BLACK);
                }

                // Añadir cada casilla al GridPane en la posición correspondiente
                grid.add(square, i, j);
            }
        }

        Scene scene = new Scene(grid, 480, 480);
        primaryStage.setTitle("Tablero de Ajedrez");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

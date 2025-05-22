package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*Crea un programa que represente el mapa en una interfaz gráfica JavaFX y que permita mover un robot desde la casilla A hasta la Z con las teclas de los cursores o AWSD.
Si se pisa una mina deberá mostrar un cuadro de diálogo de error.
Si se llega a la meta un cuadro de dialogo de éxito */
public class Mapa extends Application {
    String[] mapa = {
            "  Z       ",
            " *        ",
            "  *  *    ",
            "          ",
            " A        "
    };

    // Variables globales
    // Posición actual del personaje (fila, columna)
    int fila;
    int columna;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // buscarSalida
        for (int i = 0; i < mapa.length; i++)
            if (mapa[i].indexOf('A') != -1) {
                fila = i;
                columna = mapa[i].indexOf('A');
            }

        // Representar el mapa de una escena con un GridPane con etiquetas
        GridPane gridPane = new GridPane();
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length(); j++) {
                Label lbl = new Label(String.valueOf(mapa[i].charAt(j)));
                lbl.setPrefSize(50, 50);
                lbl.setAlignment(Pos.CENTER);
                String css = "-fx-background-color:rgb(141, 187, 224); -fx-border-color: black black black black; -fx-border-width: 1 1 1 1;";
                switch (String.valueOf(mapa[i].charAt(j))) {
                    case "*":
                        css += "-fx-background-color:rgb(224, 141, 141);";
                        break;
                    case "A":
                        css += "-fx-background-color: rgb(141, 224, 155);";
                        break;
                    case "Z":
                        css += "-fx-background-color: rgb(216, 224, 141);";
                        break;
                }
                lbl.setStyle(css);

                // Implementar evento de pulsación de teclas en las etiquetas
                // Reconocer teclas válidas
                // Mover personaje
                gridPane.add(lbl, j, i);
            }
        }

        primaryStage.setTitle("Mapa");
        primaryStage.setResizable(false);
        Scene scene = new Scene(gridPane);
        scene.setOnKeyTyped(e -> {
            System.out.println(e.getCode().toString() + " - " + e.getCharacter());
            switch (e.getCharacter()) {
                case "a":
                    break;
                case "w":
                    break;
                case "s":
                    break;
                case "d":
                    break;
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
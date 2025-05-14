/*Crea una aplicación que contenga un HBox con dos ImageView. Los ImageView deben
mostrar dos imágenes diferentes. Al hacer clic en cada imagen, se debe mostrar un
mensaje en la consola que indique qué imagen ha sido pulsada. */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ejemplo9_HBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(20);
        Image image1 = new Image("https://via.placeholder.com/150"); // Imagen 1 (puedes usar otra URL de imagen)
        Image image2 = new Image("https://via.placeholder.com/150/0000FF/808080");

        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);

        
        imageView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Imagen 1 ha sido pulsada");
            }
        });

      
        imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Imagen 2 ha sido pulsada");
            }
        });


        hbox.getChildren().addAll(imageView1, imageView2);
        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setTitle("HBox con ImageView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

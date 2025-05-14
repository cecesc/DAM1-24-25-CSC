/*Crea una aplicación que contenga un FlowPane con varias ImageView. Las ImageView
deben mostrar diferentes imágenes. Al hacer clic en cada imagen, se debe mostrar un
mensaje en la consola que indique qué imagen ha sido pulsada.
*/
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ejemplo12_FlowPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane(10, 10);
        Image image1 = new Image("https://via.placeholder.com/150"); // Imagen 1
        Image image2 = new Image("https://via.placeholder.com/150/0000FF/808080"); // Imagen 2
        Image image3 = new Image("https://via.placeholder.com/150/FF5733"); // Imagen 3

        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);

        // Establecer tamaño de las imágenes
        imageView1.setFitWidth(100);
        imageView1.setFitHeight(100);
        imageView2.setFitWidth(100);
        imageView2.setFitHeight(100);
        imageView3.setFitWidth(100);
        imageView3.setFitHeight(100);

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

        imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Imagen 3 ha sido pulsada");
            }
        });

        flowPane.getChildren().addAll(imageView1, imageView2, imageView3);

        Scene scene = new Scene(flowPane, 400, 300);
        primaryStage.setTitle("FlowPane con ImageView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

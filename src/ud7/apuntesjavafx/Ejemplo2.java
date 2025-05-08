/*Crear una ventana con un campo de texto (TextField) y un botón que, al
hacer clic imprima el texto por consola. Amplía para que imprima el texto en una etiqueta
(Label) en la pantalla.
 */
package ud7.apuntesjavafx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ejemplo2 extends Application {
public static void main(String[] args) {
    launch(args);
}
    @Override
    public void start(Stage primaryStage) throws Exception {
    TextField TextField = new TextField("Escribe tu nombre");    
    Button button = new Button("Saludar");
    Label label = new Label();
    button.setOnAction(e -> {
        label.setText("Hola "+ TextField.getText()+ ". Encantado de conocerte");
    });

    VBox vBox = new VBox(TextField, button, label);
    Scene scene = new Scene( vBox , 300,200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Saludo");
    primaryStage.setResizable(false);

    primaryStage.show();
}

}

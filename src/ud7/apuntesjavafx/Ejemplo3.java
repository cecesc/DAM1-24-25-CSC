/*Crear una ventana con dos campos de texto y un botón que, al hacer clic,
muestre la suma de los números ingresados en un tercer campo de texto o en una
etiqueta */
package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo3 extends Application {
    TextField num1 = new TextField("Escribe el primer número");
    TextField num2 = new TextField("Escribe el segundo número");
    Button btnSumar = new Button("Sumar");
    Label lblResultado = new Label();

    public static void main(String[] args) {
        launch();
    }

    public void sumar() {

        int resultado;
        int n1 = 0, n2 = 0;
        try {
            n1 = Integer.parseInt(num1.getText());
            n2 = Integer.parseInt(num2.getText());
            resultado = n1 + n2;
            lblResultado.setText(String.valueOf(resultado));
        } catch (Exception ex) {
            lblResultado.setText("ERROR: Algún operando no es un número");
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        num1.setOnKeyTyped(e -> sumar());

        btnSumar.setOnAction(e -> sumar());

        VBox vbox = new VBox(num1, num2, btnSumar, lblResultado);

        Scene scene = new Scene(vbox, 300, 150);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

}
/*Actividad 4. Crear una ventana con un campo de texto y un botón que, al hacer clic,
cambie el color de fondo de la ventana (o de una etiqueta) al color especificado en el
campo de texto. (Investiga setBackground() de la clase Region o setStyle() de la clase
Node para cambiar el color de fondo de un nodo).
Actividad 5. Crear una ventana con una lista desplegable de colores (ComboBox) y un
botón que, al hacer clic, cambie el color de fondo de la ventana al color seleccionado en
la lista desplegable.
Para prescindir del botón y cambiar el color con sólo seleccionarlo en el desplegable,
investiga el evento onAction del ComboBox que se dispara al modificar la propiedad
value.
Actividad 6. Crear una ventana con un área de texto (TextArea), un campo de texto y un
botón que, al hacer clic, agregue el texto del campo de texto a la lista de elementos en el
área de texto.
Actividad 7. Crea una aplicación que permita introducir en cuadros de texto las notas de
un grupo de alumnos, una a una, y que al mismo tiempo las vaya mostrando en orden
alfabético de nombre de alumno en un control de tipo lista (ListView) y que muestre
también la media de la clase, la nota más alta y la más baja.
Crea otros ejemplos de aplicaciones para probar otros controles
● Crea una aplicación que permita introducir la fecha de tu cumpleaños (DatePicker)
y calcule y muestre en una etiqueta cuantos días faltan.
● Crea una aplicación que permita seleccionar un color (ColorPicker) y realice una
acción con ese color (cambiar el fondo, color de letra, hacer un dibujo…)
● Utiliza TreeView para mostrar las características de un grupo de personajes de rol.
● Utiliza TableView para mostrar la misma información anterior.
Sobre el control/clase ListView<T>:
● Puede contener una lista de cualquier tipo de elementos T */
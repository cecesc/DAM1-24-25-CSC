//Autor:Celia Sanmartín Chapela

package ud7.cscexamen.entrenamiento;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class EntrenamientoFX extends Application {

    private ListaEntrenamientos listentrenos = new ListaEntrenamientos();
    private TextField campoNombre, campoFecha, campoKilometros;
    private TextArea areaResultado;
    private final String FICHERO = "src/ud7/entrenamiento.dat";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Entrenamiento");

        campoNombre = new TextField();
        campoFecha = new TextField();
        campoKilometros = new TextField();

        campoNombre.setPromptText("Nombre");
        campoFecha.setPromptText("Fecha");
        campoKilometros.setPromptText("Kilometros");

        areaResultado = new TextArea();
        areaResultado.setEditable(false);

        MenuBar menuBar = new MenuBar();
        Menu menuOpciones = new Menu("Menú");

        MenuItem itemMenu1 = new MenuItem("Guardar archivo");
        MenuItem itemMenu2 = new MenuItem("Cargar archivo");

        menuOpciones.getItems().addAll(
                itemMenu1,
                itemMenu2);

        menuBar.getMenus().add(menuOpciones);

        itemMenu1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar archivo");
            File archivo = fileChooser.showSaveDialog(stage);
            if (archivo != null) {
                try {
                    listentrenos.guardarLista(archivo.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemMenu2.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Cargar archivo");
            File archivo = fileChooser.showOpenDialog(stage);
            if (archivo != null) {
                try {
                    listentrenos = ListaEntrenamientos.cargarLista(archivo.getAbsolutePath());
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        BorderPane bordPane = new BorderPane();
        bordPane.setTop(menuBar);

        Button btnGuardar = new Button("Guardar Entrenamiento");
        Button btnListar = new Button("Listar Entrenamientos");

        btnGuardar.setOnAction(e -> añadirEntrenamiento());
        btnListar.setOnAction(e -> listarEntrenamientos());

        VBox entradaDatos = new VBox(5, bordPane, campoNombre, campoFecha, campoKilometros, btnGuardar);
        VBox botonesBox = new VBox(5, btnListar);
        VBox panelIzquierdo = new VBox(15, entradaDatos, botonesBox);
        panelIzquierdo.setPrefWidth(200);

        HBox principal = new HBox(25, panelIzquierdo, areaResultado);

        Scene scene = new Scene(principal, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void añadirEntrenamiento() {
        try {
            String nombre = campoNombre.getText().trim();
            String fecha = campoFecha.getText().trim();
            double kilometros = Double.parseDouble(campoKilometros.getText().trim());

            if (nombre.isEmpty()) {
                areaResultado.setText("ERROR: El nombre no puede estar vacío.");
                return;
            }

            List<Entrenamiento> entrenamientos = leerEntrenamientos();

            entrenamientos.add(new Entrenamiento(nombre, fecha, kilometros));
            guardarEntrenamiento(entrenamientos);
            areaResultado.setText("Entrenamiento guardado correctamente.");

            campoNombre.clear();
            campoFecha.clear();
            campoKilometros.clear();

        } catch (NumberFormatException e) {
            areaResultado.setText("ERROR: Kilometros con formato incorrecto.");
        } catch (IOException | ClassNotFoundException e) {
            areaResultado.setText("ERROR al guardar el entrenamiento: " + e.getMessage());
        }
    }

    private void listarEntrenamientos() {
        try {
            List<Entrenamiento> entrenamientos = leerEntrenamientos();
            entrenamientos.sort(Comparator.comparing(Entrenamiento::getFecha));

            if (entrenamientos.isEmpty()) {
                areaResultado.setText("No hay productos en el inventario.");
            } else {
                StringBuilder sb = new StringBuilder("LISTADO DE ENTRENAMIENTOS:\n");
                for (Entrenamiento e : entrenamientos) {
                    sb.append(e).append("\n");
                }
                areaResultado.setText(sb.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            areaResultado.setText("ERROR al leer el listado de entrenamiento: " + e.getMessage());
        }
    }

    private List<Entrenamiento> leerEntrenamientos() throws IOException, ClassNotFoundException {
        File archivo = new File(FICHERO);
        if (!archivo.exists())
            return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Entrenamiento>) ois.readObject();
        }
    }

    private void guardarEntrenamiento(List<Entrenamiento> entrenamientos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(entrenamientos);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
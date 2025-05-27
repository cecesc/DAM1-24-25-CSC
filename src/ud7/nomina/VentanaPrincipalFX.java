package ud7.nomina;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class VentanaPrincipalFX extends Application {

    private ListaEmpleados empleados = new ListaEmpleados();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nómina");

        // Menú
        MenuBar menuBar = new MenuBar();
        Menu menuOpciones = new Menu("Menú");

        MenuItem itemMenu1 = new MenuItem("Agregar empleado");
        MenuItem itemMenu2 = new MenuItem("Calcular nómina");
        MenuItem itemMenu3 = new MenuItem("Guardar archivo");
        MenuItem itemMenu4 = new MenuItem("Cargar archivo");
        MenuItem itemMenu5 = new MenuItem("Editar/Eliminar empleado");

        menuOpciones.getItems().addAll(
            itemMenu1,
            itemMenu2,
            new SeparatorMenuItem(),
            itemMenu3,
            itemMenu4,
            itemMenu5
        );

        menuBar.getMenus().add(menuOpciones);

        // Eventos
      

        itemMenu3.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar archivo");
            File archivo = fileChooser.showSaveDialog(primaryStage);
            if (archivo != null) {
                try {
                    empleados.guardarLista(archivo.getAbsolutePath());
                    mostrarAlerta("Éxito", "Archivo guardado exitosamente");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemMenu4.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Cargar archivo");
            File archivo = fileChooser.showOpenDialog(primaryStage);
            if (archivo != null) {
                try {
                    empleados = ListaEmpleados.cargarLista(archivo.getAbsolutePath());
                    mostrarAlerta("Éxito", "Archivo cargado exitosamente");
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        // Layout
        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

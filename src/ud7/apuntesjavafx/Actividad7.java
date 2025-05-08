package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Actividad7 extends Application {
    TextField txtNombre = new TextField("Nombre del alumno");
    TextField txtNota = new TextField("Nota");
    Button btnAgregar = new Button("Agregar nota");
    ListView<String> lista = new ListView<>();
    Label lblEstadisticas = new Label();

    TreeMap<String, Double> notas = new TreeMap<>();

    public static void main(String[] args) {
        launch();
    }

    public void agregarNota() {
        try {
            String nombre = txtNombre.getText();
            double nota = Double.parseDouble(txtNota.getText());
            notas.put(nombre, nota);

            actualizarLista();
            actualizarEstadisticas();

            txtNombre.clear();
            txtNota.clear();
        } catch (NumberFormatException e) {
            lblEstadisticas.setText("Nota inválida.");
        }
    }

    public void actualizarLista() {
        lista.getItems().clear();
        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            lista.getItems().add(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void actualizarEstadisticas() {
        if (notas.isEmpty()) return;

        Collection<Double> valores = notas.values();
        double suma = 0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        for (double nota : valores) {
            suma += nota;
            if (nota > max) max = nota;
            if (nota < min) min = nota;
        }

        double media = suma / valores.size();
        lblEstadisticas.setText("Media: " + String.format("%.2f", media)
                + " | Máxima: " + max + " | Mínima: " + min);
    }

    @Override
    public void start(Stage stage) {
        btnAgregar.setOnAction(e -> agregarNota());

        VBox vbox = new VBox(txtNombre, txtNota, btnAgregar, lista, lblEstadisticas);
        Scene scene = new Scene(vbox, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Notas de Alumnos");
        stage.show();
    }
}

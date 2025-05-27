package ud7.examenprueba;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class AppNotasFX extends Application {

    // Área de texto donde mostraremos los promedios en la interfaz
    private TextArea areaResultado;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Promedios de Estudiantes");

        // Creamos un botón que, al hacer clic, calculará los promedios
        Button btnCalcular = new Button("Calcular Promedios");

        // Creamos el área de texto donde se mostrarán los resultados
        areaResultado = new TextArea();
        areaResultado.setEditable(false); // Solo lectura

        // Asociamos al botón una acción: ejecutar el método calcularPromedios()
        btnCalcular.setOnAction(e -> calcularPromedios());

        // Organizamos los componentes verticalmente en un VBox
        VBox root = new VBox(10, btnCalcular, areaResultado);
        root.setPadding(new javafx.geometry.Insets(10));

        // Creamos la escena y la asignamos a la ventana (stage)
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show(); // Mostramos la ventana
    }

    // Este método se ejecuta al pulsar el botón
    private void calcularPromedios() {
        String entrada = "src/ud7/examenprueba/notas.txt";      // Archivo de entrada con los datos
        String salida = "src/ud7/examenprueba/promedios.txt";   // Archivo de salida con los resultados
        StringBuilder resultado = new StringBuilder(); // Para acumular lo que se va a mostrar

        // Intentamos abrir y leer el archivo
        try (
            BufferedReader lector = new BufferedReader(new FileReader(entrada));         // Lectura
            BufferedWriter escritor = new BufferedWriter(new FileWriter(salida))         // Escritura
        ) {
            String linea;

            // Leemos línea por línea el archivo
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(","); // Separar por comas: nombre, nota1, nota2...

                if (partes.length < 2) continue; // Si no hay notas, saltamos la línea

                String nombre = partes[0].trim(); // El primer campo es el nombre del alumno
                double suma = 0;                 // Suma total de las notas
                int total = 0;                   // Contador de notas

                // Recorremos las notas (del índice 1 en adelante)
                for (int i = 1; i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i].trim()); // Convertimos a número
                    total++;
                }

                // Calculamos el promedio
                double promedio = suma / total;

                // Preparamos la línea de resultado: "Juan Perez: 85.0"
                String info = nombre + ": " + promedio;

                // Agregamos esta línea al TextArea y al archivo
                resultado.append(info).append("\n");
                escritor.write(info);
                escritor.newLine();
            }

            // Mostramos todo el resultado en el área de texto
            areaResultado.setText(resultado.toString());

        } catch (FileNotFoundException e) {
            // Si no existe el archivo notas.txt
            areaResultado.setText("ERROR: No se encontró el archivo notas.txt");
        } catch (IOException e) {
            // Si ocurre un error de lectura o escritura
            areaResultado.setText("ERROR: Problema de lectura o escritura");
        } catch (NumberFormatException e) {
            // Si alguna nota no es un número válido
            areaResultado.setText("ERROR: Formato numérico incorrecto en una nota");
        }
    }

    public static void main(String[] args) {
        // Método principal que lanza la aplicación JavaFX
        launch(args);
    }
}
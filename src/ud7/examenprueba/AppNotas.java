package ud7.examenprueba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class AppNotas {

    public static void main(String[] args) {
        final String PATH = "src/ud7/examenprueba/";
        String ficheroEntrada = "notas.txt";
        String ficheroSalida = "promedios.txt";

        // Intentamos abrir los ficheros necesarios
        try (
            BufferedReader lector = new BufferedReader(new FileReader(PATH+ficheroEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH+ficheroSalida))
        ) {
            String linea;
            boolean hayDatos = false;

            // Leer línea por línea del fichero de entrada
            while ((linea = lector.readLine()) != null) {
                hayDatos = true;

                // Dividir por comas: [nombre, nota1, nota2, ...]
                String[] partes = linea.split(",");

                if (partes.length < 2) {
                    System.out.println("Línea con formato incorrecto: " + linea);
                    continue;
                }

                String nombre = partes[0].trim(); // El nombre está en la primera posición
                double suma = 0;
                int cantidadNotas = 0;

                try {
                    // Procesamos cada nota (desde la posición 1 en adelante)
                    for (int i = 1; i < partes.length; i++) {
                        double nota = Double.parseDouble(partes[i].trim());
                        suma += nota;
                        cantidadNotas++;
                    }

                    double promedio = suma / cantidadNotas;

                    // Escribimos en el fichero de salida el resultado
                    escritor.write(nombre + ": " + promedio);
                    escritor.newLine(); // salto de línea

                } catch (NumberFormatException e) {
                    System.out.println("Error: nota no válida para " + nombre);
                }
            }

            if (!hayDatos) {
                System.out.println("El fichero está vacío.");
            } else {
                System.out.println("Promedios escritos correctamente en " + ficheroSalida);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: el fichero " + ficheroEntrada + " no existe.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}

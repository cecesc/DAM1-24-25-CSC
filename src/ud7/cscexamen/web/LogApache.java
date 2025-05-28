//Autor:Celia Sanmartín Chapela
package ud7.cscexamen.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogApache {
    public static void main(String[] args) {
        final String PATH = "src/ud7/";
        try (
                BufferedReader lector = new BufferedReader(new FileReader(PATH + "bacharelato_access.log"));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH + "salidaDatos.txt"))) {
            String linea;
            boolean hayDatos = false;

            while ((linea = lector.readLine()) != null) {
                hayDatos = true;

            }
            if (!hayDatos) {
                System.out.println("El fichero está vacío.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: el fichero " + "bacharelato_access.log" + " no existe.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}

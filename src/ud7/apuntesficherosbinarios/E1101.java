/*Escribir en un archivo datos.dat los valores de diez números enteros.
Repite la actividad escribiendo los números enteros en el archivo datos.dat como un array
y no como números enteros individuales */
package ud7.apuntesficherosbinarios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E1101 {
    public static void main(String[] args) {
        // Escribe 10 números enteros e un fichero binario
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("src\\ud7\\apuntesficherosbinarios\\datos.dat"))) {
            for (int i = 0; i < 20; i++) {
                out.writeInt(i);
            }
        } catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }
    }
}

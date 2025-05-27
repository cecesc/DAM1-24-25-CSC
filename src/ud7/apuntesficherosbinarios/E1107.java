/*Grabar en el fichero numeros.dat una serie de números enteros no negativos
introducidos por teclado. La serie acabará cuando escribamos -1. Abrir de nuevo
numeros.dat para lectura y leer todos los números hasta el final del fichero, mostrándolos
por pantalla y copiándolos en un segundo fichero numerosCopia.dat. */
package ud7.apuntesficherosbinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class E1107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fase 1: Escritura de números en numeros.dat
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("numeros.dat"))) {
            int numero;
            System.out.println("Introduce números enteros no negativos. Introduce -1 para terminar:");
            while (true) {
                System.out.print("Número: ");
                numero = sc.nextInt();
                if (numero == -1)
                    break;
                if (numero >= 0) {
                    dos.writeInt(numero);
                } else {
                    System.out.println("Sólo se permiten números no negativos o -1 para terminar.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo en el fichero: " + e.getMessage());
            return;
        }

        // Fase 2: Lectura de numeros.dat y copia a numerosCopia.dat
        try (DataInputStream dis = new DataInputStream(new FileInputStream("numeros.dat"));
                DataOutputStream dosCopia = new DataOutputStream(new FileOutputStream("numerosCopia.dat"))) {

            System.out.println("\nContenido del fichero numeros.dat:");
            while (true) {
                int numero = dis.readInt(); // Lee un entero
                System.out.println(numero); // Muestra por pantalla
                dosCopia.writeInt(numero); // Copia al segundo fichero
            }
        } catch (EOFException e) {
            // Fin del fichero alcanzado, no es un error
            System.out.println("\nFin de lectura.");
        } catch (IOException e) {
            System.err.println("Error procesando los ficheros: " + e.getMessage());
        }

    }
}

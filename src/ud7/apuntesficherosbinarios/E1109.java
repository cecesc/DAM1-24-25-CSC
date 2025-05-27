/*Implementar un programa que registra la evolución temporal de la temperatura en
una ciudad. La aplicación mostrará un menú que permite añadir nuevos registros de
temperatura y mostrar el listado de todos los registros históricos. Cada registro constará
de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora, que
se leerá del sistema en el momento de la creación del registro.
*/
package ud7.apuntesficherosbinarios;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class E1109 {

    private static final String FICHERO = "temperaturas.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ:");
            System.out.println("1. Añadir nuevo registro de temperatura");
            System.out.println("2. Mostrar historial de registros");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    anadirRegistro(sc);
                    break;
                case 2:
                    mostrarRegistros();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // Añadir un nuevo registro de temperatura con la fecha y hora actuales
    private static void anadirRegistro(Scanner sc) {
        System.out.print("Introduce la temperatura (°C): ");
        double temperatura = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = ahora.format(formato);

        String linea = temperatura + "°C - " + fechaHora;

        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHERO, true))) {
            pw.println(linea);
            System.out.println("Registro guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    // Mostrar todos los registros guardados
    private static void mostrarRegistros() {
        System.out.println("\nHistorial de temperaturas:");
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay registros aún.");
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

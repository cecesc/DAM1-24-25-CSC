package ud4.ejercicios;

import java.util.Scanner;

public class AprobarQuimica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definición del orden de llenado de los subniveles
        String[] ordenLlenado = {
                "1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p", "5s", "4d", "5p", "6s", "4f", "5d", "6p", "7s", "5f", "6d", "7p"
        };

        // Definición de la capacidad de electrones por subnivel
        int[] capacidadElectrones = {2, 2, 6, 2, 6, 2, 10, 6, 2, 10, 6, 2, 14, 10, 6, 2, 14, 10, 6};

        while (true) {
            String nombreElemento = scanner.nextLine(); // Leer el nombre del elemento
            if (nombreElemento.equals("Exit")) {
                break; // Terminar si se recibe "Exit"
            }
            int numeroAtomico = Integer.parseInt(scanner.nextLine()); // Leer el número atómico

            // Calcular la configuración electrónica
            StringBuilder configuracion = new StringBuilder();
            int electronesRestantes = numeroAtomico;

            for (int i = 0; i < ordenLlenado.length; i++) {
                if (electronesRestantes <= 0) {
                    break; // Si no quedan electrones, salir del bucle
                }

                String subnivel = ordenLlenado[i];
                int capacidad = capacidadElectrones[i];
                int electronesEnSubnivel = Math.min(electronesRestantes, capacidad);

                configuracion.append(subnivel).append(electronesEnSubnivel).append(" ");
                electronesRestantes -= electronesEnSubnivel;
            }

            // Si Z = 0, se debe mostrar 1s0
            if (numeroAtomico == 0) {
                configuracion.append("1s0");
            }

            // Imprimir la configuración electrónica
            System.out.println(configuracion.toString().trim());
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
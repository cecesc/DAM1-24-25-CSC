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

        // Solicitar al usuario que ingrese el nombre del elemento
        System.out.println("Ingrese el nombre del elemento:");
        String nombreElemento = scanner.nextLine(); // Leer el nombre del elemento

        // Solicitar al usuario que ingrese el número atómico
        System.out.println("Ingrese el número atómico:");
        int numeroAtomico = Integer.parseInt(scanner.nextLine()); // Leer el número atómico

        // Calcular la configuración electrónica
        String[] configuracion = calcularConfiguracionElectronica(numeroAtomico, ordenLlenado, capacidadElectrones);

        // Imprimir la configuración electrónica
        System.out.print("Configuración electrónica de " + nombreElemento + ": ");
        for (String s : configuracion) {
            System.out.print(s + " "); // Imprimir cada parte de la configuración
        }
        System.out.println(); // Nueva línea al final

        scanner.close(); // Cerrar el escáner al final
    }

    private static String[] calcularConfiguracionElectronica(int numeroAtomico, String[] ordenLlenado, int[] capacidadElectrones) {
        String[] configuracion = new String[ordenLlenado.length]; // Arreglo para la configuración
        int electronesRestantes = numeroAtomico;
        int index = 0; // Índice para el arreglo de configuración

        for (int i = 0; i < ordenLlenado.length; i++) {
            if (electronesRestantes <= 0) {
                break; // Si no quedan electrones, salir del bucle
            }

            String subnivel = ordenLlenado[i];
            int capacidad = capacidadElectrones[i];
            int electronesEnSubnivel = Math.min(electronesRestantes, capacidad);

            configuracion[index] = subnivel + electronesEnSubnivel; // Almacenar la configuración en el arreglo
            index++; // Incrementar el índice
            electronesRestantes -= electronesEnSubnivel;
        }

        // Si Z = 0, se debe mostrar 1s0
        if (numeroAtomico == 0) {
            configuracion[0] = "1s0"; // Asignar 1s0 al primer índice
        }

        // Crear un nuevo arreglo con el tamaño correcto para la configuración
        String[] resultado = new String[index];
        System.arraycopy(configuracion, 0, resultado, 0, index); // Copiar solo los elementos utilizados

        return resultado; // Devolver el arreglo de configuración
    }
}
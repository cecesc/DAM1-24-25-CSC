package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class EmbarqueTransatlantico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de pasajeros
        System.out.println("Ingrese el número de pasajeros (0 para terminar):");
        int n = scanner.nextInt();

        while (n != 0) {
            // Leer las cubiertas de los pasajeros
            int[] cubiertas = new int[n];
            int[] conteoCubiertas = new int[100]; // Suponiendo que las cubiertas son menores que 100
            Arrays.fill(conteoCubiertas, 0); // Inicializar el conteo a 0

            System.out.println("Ingrese las cubiertas de los pasajeros:");
            for (int i = 0; i < n; i++) {
                cubiertas[i] = scanner.nextInt();
                conteoCubiertas[cubiertas[i]]++; // Contar pasajeros por cubierta
            }

            // Leer el número de acciones
            System.out.println("Ingrese el número de acciones:");
            int acciones = scanner.nextInt();
            for (int i = 0; i < acciones; i++) {
                String accion = scanner.next();
                if (accion.equals("EMBARQUE")) {
                    int cubierta = scanner.nextInt();
                    if (conteoCubiertas[cubierta] > 0) {
                        int pasajerosEmbarcados = conteoCubiertas[cubierta];
                        conteoCubiertas[cubierta] = 0; // Eliminar la cubierta ya embarcada
                        n -= pasajerosEmbarcados; // Actualizar el número de pasajeros restantes
                    }
                    System.out.println("Pasajeros restantes: " + n); // Pasajeros restantes
                } else if (accion.equals("CONSULTA")) {
                    int posicion = scanner.nextInt() - 1; // Convertir a índice 0
                    System.out.println("Cubierta del pasajero en la posición " + (posicion + 1) + ": " + cubiertas[posicion]); // Cubierta del pasajero
                }
            }


               }

        scanner.close();
    }
}
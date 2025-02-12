package ud4.ejercicios;

import java.util.Scanner;

public class OperacionAsfalto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de intersecciones
        System.out.println("Ingrese el número de intersecciones:");
        int numIntersecciones = scanner.nextInt();

        // Leer el número de calles
        System.out.println("Ingrese el número de calles (0 para terminar):");
        int numCalles = scanner.nextInt();

        if (numCalles == 0) {
            return; // Terminar si se recibe 0
        }

        int[] grados = new int[numIntersecciones + 1]; // Grados de las intersecciones (1-indexed)

        // Leer las calles y actualizar los grados
        System.out.println("Ingrese las calles (intersección1 intersección2):");
        for (int i = 0; i < numCalles; i++) {
            int interseccion1 = scanner.nextInt();
            int interseccion2 = scanner.nextInt();
            grados[interseccion1]++;
            grados[interseccion2]++;
        }

        // Contar cuántas intersecciones tienen un grado impar
        int gradosImpares = 0;
        for (int i = 1; i <= numIntersecciones; i++) {
            if (grados[i] % 2 != 0) {
                gradosImpares++;
            }
        }

        // Determinar si se puede asfaltar
        if (gradosImpares == 0) {
            System.out.println("SI"); // Ciclo Euleriano
        } else if (gradosImpares == 2) {
            System.out.println("SI"); // Camino Euleriano
        } else {
            System.out.println("NO"); // Ninguno
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
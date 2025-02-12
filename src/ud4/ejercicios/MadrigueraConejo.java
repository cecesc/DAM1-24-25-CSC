package ud4.ejercicios;
import java.util.Scanner;

public class MadrigueraConejo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de conejos y agujeros
        System.out.print("Ingrese el número de conejos y agujeros (0 para terminar): ");
        int N = scanner.nextInt();

        // Terminar si se encuentra con un 0
        if (N == 0) {
            scanner.close();
            return;
        }

        // Leer los diámetros de los agujeros
        int[] agujeros = new int[N];
        System.out.println("Ingrese los diámetros de los agujeros:");
        for (int i = 0; i < N; i++) {
            agujeros[i] = scanner.nextInt();
        }

        // Crear un arreglo para almacenar el primer agujero más grande
        int[] primerAgujeroGrande = new int[N];

        // Inicializar el último agujero como un agujero grande
        primerAgujeroGrande[N - 1] = N; // El último conejo siempre sale por el agujero grande

        // Llenar el arreglo de agujeros más grandes
        for (int i = N - 2; i >= 0; i--) {
            primerAgujeroGrande[i] = primerAgujeroGrande[i + 1];
            if (agujeros[i] < agujeros[primerAgujeroGrande[i + 1]]) {
                primerAgujeroGrande[i] = i + 1; // Guardar el índice del primer agujero más grande
            }
        }

        // Calcular la distancia total recorrida
        int totalDistancia = 0;
        for (int i = 0; i < N; i++) {
            int distancia = primerAgujeroGrande[i] - i; // Distancia recorrida por el conejo
            totalDistancia += distancia;
        }

        // Imprimir el resultado
        System.out.println("La distancia total recorrida por los conejos es: " + totalDistancia);

        scanner.close();
    }
}
package ud2.ejercicios;
import java.util.Scanner;
public class Cine {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingrese el número de vecinos esperando en la fila (0 para terminar): ");
            int numVecinos = scanner.nextInt(); // Leer el número de vecinos
            if (numVecinos == 0) break; // Terminar si no hay vecinos
            
            int[] asientos = new int[numVecinos];
            System.out.println("Ingrese los números de asiento de cada vecino:");
            for (int i = 0; i < numVecinos; i++) {
                asientos[i] = scanner.nextInt(); // Leer los números de asiento
            }
            
            // Contar cuántos asientos impares hay
            int countImpares = 0;
            for (int asiento : asientos) {
                if (asiento % 2 != 0) {
                    countImpares++;
                }
            }
            
            // Verificar si todos los asientos impares están al final
            boolean puedeAbrirPuerta = true;
            for (int i = 0; i < numVecinos - countImpares; i++) {
                if (asientos[i] % 2 != 0) {
                    puedeAbrirPuerta = false; // Encontramos un impar antes de los pares
                    break;
                }
            }
            
            // Imprimir el resultado
            if (puedeAbrirPuerta) {
                System.out.println("SI " + countImpares + " se quedarán en la puerta.");
            } else {
                System.out.println("NO se puede abrir la segunda puerta.");
            }
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}

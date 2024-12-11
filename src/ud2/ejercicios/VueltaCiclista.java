package ud2.ejercicios;
import java.util.Scanner;
public class VueltaCiclista {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce las distancias recorridas (termina con 0):");
        
        while (true) {
            int totalKilometros = 0;
            int distancia;
            
            // Leer las distancias hasta que se encuentre un 0
            while (true) {
                distancia = scanner.nextInt();
                if (distancia == 0) break; // Terminar si se encuentra un 0
                totalKilometros += distancia * 2; // Sumar ida y vuelta
            }
            
            // Si se han leído distancias, imprimir el total
            if (totalKilometros > 0) {
                System.out.println("Total de kilómetros recorridos: " + totalKilometros);
            } else {
                break; // Si no hay distancias, salir del bucle
            }
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}


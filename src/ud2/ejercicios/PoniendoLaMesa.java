package ud2.ejercicios;

import java.util.Scanner;

public class PoniendoLaMesa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese el número de copas
            System.out.print("Ingrese el número de copas (0 para salir): ");
            int copas = scanner.nextInt();
            if (copas == 0) {
                break; // Terminar si se ingresa un cero
            }
            
            int paseos = 0; // Contador de paseos
            
            // Alternar paseos
            while (copas > 0) {
                paseos++; // Contar el paseo del hermano
                copas--; // El hermano lleva una copa
                
                if (copas > 0) { // Verificar si aún quedan copas
                    paseos++; // Contar tu paseo
                    if (copas % 2 == 0) {
                        copas -= 2; // Llevas dos copas si quedan un número par
                    } else {
                        copas--; // Llevas una copa si queda un número impar
                    }
                }
            }
            
            // Imprimir el número total de paseos
            System.out.println("Número total de paseos: " + paseos);
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}
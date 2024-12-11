package ud2.ejercicios;

import java.util.Scanner;

public class AsaltoAlCastillo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce el número de soldados (0 para terminar):");
        
        while (true) {
            int soldados = scanner.nextInt(); // Leer el número de soldados
            if (soldados == 0) break; // Terminar si el número de soldados es 0
            
            int contadorDivisores = 0;
            
            // Calcular el número de divisores
            for (int i = 1; i * i <= soldados; i++) {
                if (soldados % i == 0) {
                    contadorDivisores++; // i es un divisor
                    if (i != soldados / i) {
                        contadorDivisores++; // n/i es otro divisor
                    }
                }
            }
            
            // Imprimir el número de configuraciones posibles
            System.out.println("Número de configuraciones posibles para " + soldados + " soldados: " + contadorDivisores);
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}
package ud2.ejercicios;

import java.util.Scanner;

public class FamiliaNumerosa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese el número de comensales y albóndigas restantes
            System.out.print("Ingrese el número de comensales y albóndigas restantes (número negativo para salir): ");
            int c = scanner.nextInt(); // Número de comensales
            
            // Terminar si se ingresa un número negativo
            if (c < 0) {
                break;
            }
            
            int n = scanner.nextInt(); // Albóndigas restantes
            
            // Calcular el menor y mayor número de albóndigas iniciales
            int menor = n + (c - 1); // Menor cantidad de albóndigas
            int mayor = n + (c * (n / (c - 1))); // Mayor cantidad de albóndigas
            
            // Ajustar el mayor para que sea un múltiplo de c
            if (mayor % c != 0) {
                mayor += c - (mayor % c);
            }
            
            System.out.println(menor + " " + mayor);
        }
        
        scanner.close();
    }
}
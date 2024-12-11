package ud2.ejercicios;

import java.util.Scanner;

public class Parchis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese los datos
            System.out.print("Ingrese el total de casillas, posición actual y tirada de dados (0 0 0 para salir): ");
            int c = scanner.nextInt(); // Total de casillas
            int p = scanner.nextInt(); // Posición actual
            int t = scanner.nextInt(); // Tirada de dados
            
            // Terminar si se ingresan todos ceros
            if (c == 0 && p == 0 && t == 0) {
                break;
            }
            
            // Calcular la nueva posición
            int nuevaPosicion = p + t;
            
            if (nuevaPosicion > c) {
                // Calcular el rebote
                nuevaPosicion = c - (nuevaPosicion - c);
            }
            
            // Imprimir la posición final
            System.out.println("La nueva posición es: " + nuevaPosicion);
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}
package ud2.ejercicios;

import java.util.Scanner;

public class Pinchazo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese los datos
            System.out.print("Ingrese el punto inicial y la posición del pinchazo (0 0 para salir): ");
            int i = scanner.nextInt(); // Punto inicial
            int p = scanner.nextInt(); // Posición del pinchazo
            
            // Terminar si se ingresan ambos ceros
            if (i == 0 && p == 0) {
                break;
            }
            
            // Normalizar las posiciones
            i = i % 360;
            p = p % 360;
            
            // Verificar condiciones
            if (i == p) {
                System.out.println("DA IGUAL");
            } else if (i == (p + 180) % 360) {
                System.out.println("DA IGUAL");
            } else {
                // Calcular distancias
                int distanciaAscendente = (p - i + 360) % 360;
                int distanciaDescendente = (i - p + 360) % 360;
                
                if (distanciaAscendente < distanciaDescendente) {
                    System.out.println("ASCENDENTE");
                } else {
                    System.out.println("DESCENDENTE");
                }
            }
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}
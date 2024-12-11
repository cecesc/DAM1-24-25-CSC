package ud2.ejercicios;

import java.util.Scanner;

public class CucharadasDeSopa {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Bucle infinito para permitir múltiples entradas
        while (true) {
            // Pedir al usuario que ingrese los valores de a, b y n
            System.out.print("Ingresa el mínimo de cucharadas que dice Mafalda (a) o -1 para salir: ");
            int a = scanner.nextInt(); // Leer el mínimo de cucharadas que dice Mafalda
            
            // Opción para salir del bucle
            if (a == -1) {
                break; // Salir del bucle si el usuario ingresa -1
            }
            
            System.out.print("Ingresa el máximo de cucharadas que dice el padre (b): ");
            int b = scanner.nextInt(); // Leer el máximo de cucharadas que dice el padre
            
            System.out.print("Ingresa el total de cucharadas en el plato (n): ");
            int n = scanner.nextInt(); // Leer el total de cucharadas en el plato
            
            // Calcular el número de respuestas correctas
            int respuestasCorrectas = 0;
            for (int cucharadas = a; cucharadas <= b; cucharadas++) {
                if (cucharadas <= n) {
                    respuestasCorrectas++;
                }
            }
            
            // Imprimir el resultado para el caso de prueba actual
            System.out.println("Número de respuestas correctas: " + respuestasCorrectas);
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}
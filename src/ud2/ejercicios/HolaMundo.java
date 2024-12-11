package ud2.ejercicios;


import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada
        Scanner scanner = new Scanner(System.in);
        
        // Leer el número de veces que se debe imprimir el mensaje
        System.out.print("Introduce un número (0 ≤ n ≤ 5): ");
        int n = scanner.nextInt();
        
        // Imprimir "Hola mundo." n veces
        for (int i = 0; i < n; i++) {
            System.out.println("Hola mundo.");
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}

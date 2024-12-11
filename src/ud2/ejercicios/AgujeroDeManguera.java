package ud2.ejercicios;
  import java.util.Scanner;
public class AgujeroDeManguera {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Introduce el número de agujeros (0 para terminar): ");
            int N = scanner.nextInt(); // Leer el número de agujeros
            if (N == 0) break; // Terminar si N es 0
            
            System.out.print("Introduce la longitud de los parches: ");
            int L = scanner.nextInt(); // Leer la longitud de los parches
            
            int parchesNecesarios = 0; // Contador de parches
            int i = 0; // Contador de agujeros leídos
            int posicionAgujeroAnterior = -1; // Para almacenar la posición del último agujero leído
            
            System.out.println("Introduce las posiciones de los agujeros:");
            while (i < N) {
                // Leer la posición del agujero actual
                int posicionAgujeroActual = scanner.nextInt();
                
                // Si es el primer agujero o si el agujero actual está fuera del rango del parche anterior
                if (posicionAgujeroAnterior == -1 || posicionAgujeroActual > posicionAgujeroAnterior + L) {
                    parchesNecesarios++; // Necesitamos un nuevo parche
                    posicionAgujeroAnterior = posicionAgujeroActual; // Actualizar la posición del último agujero
                    System.out.println("Se necesita un nuevo parche para cubrir el agujero en la posición: " + posicionAgujeroActual);
                }
                
                // Avanzar el índice de agujeros
                while (i < N && posicionAgujeroActual <= posicionAgujeroAnterior + L) {
                    posicionAgujeroActual = scanner.nextInt(); // Leer el siguiente agujero
                    i++; // Incrementar el contador de agujeros
                }
                
                // Actualizar el contador de agujeros
                i++;
            }
            
            // Imprimir el número mínimo de parches necesarios
            System.out.println("Número mínimo de parches necesarios: " + parchesNecesarios);
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}
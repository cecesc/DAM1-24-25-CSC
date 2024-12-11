package ud2.ejercicios;
import java.util.Scanner;

public class FormacionEscudos {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.print("Introduce el número de legionarios (0 para terminar): ");
                int legionarios = scanner.nextInt();
                if (legionarios == 0) {
                    break; // Terminar el programa si la entrada es 0
                }
                
                int totalEscudos = 0;
                
                while (legionarios > 0) {
                    // Encontrar el mayor cuadrado posible
                    int k = (int) Math.sqrt(legionarios);
                    int cuadrados = k * k; // Número de legionarios en el cuadrado
                    
                    // Calcular escudos necesarios
                    totalEscudos += cuadrados + (4 * k - 4); // Escudos para el cuadrado + escudos en los flancos
                    legionarios -= cuadrados; // Restar legionarios utilizados
                }
                
                System.out.println("Total de escudos necesarios: " + totalEscudos);
            }
            
            scanner.close();
        }
    }
package ud2.ejercicios;
import java.util.Scanner;
public class CampoFutbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Preguntar por el área en metros cuadrados
            System.out.print("Ingrese el área en metros cuadrados (0 para terminar): ");
            int area = scanner.nextInt(); // Área en metros cuadrados
            
            // Preguntar por la estimación en campos de fútbol
            System.out.print("Ingrese la estimación en campos de fútbol: ");
            int estimacion = scanner.nextInt(); // Estimación en campos de fútbol
            
            // Terminar si se ingresan ambos ceros
            if (area == 0 && estimacion == 0) {
                break;
            }
            
            // Calcular el área estimada en metros cuadrados
            int areaEstimado = estimacion * 4050; // Usamos el área mínima para la estimación
            
            // Verificar si el área está dentro del rango de un campo de fútbol
            if (areaEstimado >= 4050 && areaEstimado <= 10800) {
                // Verificar si el área dada puede ser igual a un campo de fútbol
                if (area >= areaEstimado && area <= areaEstimado + (estimacion * (10800 - 4050))) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
        
        // Cerrar el Scanner
        scanner.close();
    }

}

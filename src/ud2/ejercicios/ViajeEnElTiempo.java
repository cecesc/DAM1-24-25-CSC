package ud2.ejercicios;
import java.util.Scanner;

public class ViajeEnElTiempo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingrese la secuencia de números (finalice con -1): ");
            int actual = scanner.nextInt(); // Leer el primer número
            if (actual == -1) break; // Terminar si se encuentra -1
            
            int cambios = 0;
            int diferencia = 0;
            boolean primeraDiferencia = true;

            while (true) {
                int siguiente = scanner.nextInt(); // Leer el siguiente número
                if (siguiente == -1) break; // Terminar si se encuentra -1

                // Calcular la diferencia
                int nuevaDiferencia = siguiente - actual;
                if (nuevaDiferencia < 0) {
                    nuevaDiferencia += 1000000; // Ajustar para el espacio circular
                }

                // Si es la primera diferencia, la guardamos
                if (primeraDiferencia) {
                    diferencia = nuevaDiferencia;
                    primeraDiferencia = false;
                } else {
                    // Comparar diferencias
                    if (nuevaDiferencia != diferencia) {
                        cambios++;
                        diferencia = nuevaDiferencia; // Actualizar la diferencia
                    }
                }

                // Actualizar el número anterior
                actual = siguiente; // Aquí actualizamos 'actual' para el siguiente ciclo
            }

            // Calcular el siguiente número
            int siguienteNumero = (actual + diferencia) % 1000000;

            // Imprimir el resultado
            System.out.println("Número de cambios: " + cambios + ", Siguiente número: " + siguienteNumero);
        }
        
        scanner.close();
    }
}
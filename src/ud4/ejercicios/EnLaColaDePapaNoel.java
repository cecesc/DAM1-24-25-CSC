package ud4.ejercicios;

import java.util.Scanner;

public class EnLaColaDePapaNoel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer n (número de niños) y a (posición de Aitor)
        System.out.print("Ingrese el número de niños y la posición de Aitor: ");
        int n = scanner.nextInt();
        int a = scanner.nextInt() - 1; // Convertir a 0-indexed

        // Leer el número de regalos que quiere pedir cada niño
        System.out.println("Ingrese el número de regalos que quiere pedir cada niño (separados por espacio):");
        int[] regalos = new int[n];
        for (int j = 0; j < n; j++) {
            regalos[j] = scanner.nextInt();
        }

        // Simular la cola de atención
        int tiempoEspera = 0;
        int index = 0; // Índice para la posición actual en la cola

        while (index < n) {
            // Papá Noel atiende al niño en la posición actual
            tiempoEspera += 2; // Papá Noel atiende durante 2 minutos
            regalos[index]--; // Reducir el número de regalos del niño actual

            // Si el niño actual ha terminado de pedir regalos
            if (regalos[index] == 0) {
                // Si el niño actual es Aitor, salimos del bucle
                if (index == a) {
                    break;
                }
                // Mover al siguiente niño en la cola
                index++;
            } else {
                // Si aún tiene regalos, mover al final de la cola
                // Guardar el número de regalos y avanzar el índice
                int temp = regalos[index];
                // Desplazar hacia la izquierda
                for (int k = index; k < n - 1; k++) {
                    regalos[k] = regalos[k + 1];
                }
                regalos[n - 1] = temp; // Colocar al niño de vuelta al final
            }
        }

        // Imprimir el tiempo total de espera
        System.out.println("El tiempo que Marcos tendrá que esperar es: " + tiempoEspera + " minutos.");

        scanner.close();
    }
}
package ud4.arraysejercicios;

import java.util.Scanner;

public class EP0519 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Registrar la llegada de los corredores
        System.out.println("Introduce el número de corredores que llegan a la meta:");
        int n = sc.nextInt();
        int[] ranking = new int[n];

        System.out.println("Introduce los dorsales de los corredores en orden de llegada:");
        for (int i = 0; i < n; i++) {
            ranking[i] = sc.nextInt();
        }

        // Mover los menores de edad un puesto hacia adelante
        System.out.println("Introduce los dorsales de los corredores menores de edad (-1 para finalizar):");
        while (true) {
            int menor = sc.nextInt();
            if (menor == -1) {
                break;
            }
            for (int i = 0; i < ranking.length; i++) {
                if (ranking[i] == menor && i > 0) { // Encontrar el dorsal y moverlo
                    int temp = ranking[i - 1];
                    ranking[i - 1] = menor;
                    ranking[i] = temp;
                    break;
                }
            }
        }

        // Expulsar a los corredores dopados
        System.out.println("Introduce los dorsales de los corredores positivos en el test antidopaje (-1 para finalizar):");
        while (true) {
            int dopado = sc.nextInt();
            if (dopado == -1) {
                break;
            }
            for (int i = 0; i < ranking.length; i++) {
                if (ranking[i] == dopado) {
                    // Mover todos los elementos siguientes una posición hacia adelante
                    for (int j = i; j < ranking.length - 1; j++) {
                        ranking[j] = ranking[j + 1];
                    }
                    ranking[ranking.length - 1] = 0; // Marcar al final como vacío
                    break;
                }
            }
        }

        // Relegar a los últimos puestos a los corredores que no pagaron la inscripción
        System.out.println("Introduce los dorsales de los corredores que no pagaron la inscripción (-1 para finalizar):");
        while (true) {
            int noPago = sc.nextInt();
            if (noPago == -1) {
                break;
            }
            for (int i = 0; i < ranking.length; i++) {
                if (ranking[i] == noPago) {
                    // Mover el dorsal al final
                    int temp = ranking[i];
                    for (int j = i; j < ranking.length - 1; j++) {
                        ranking[j] = ranking[j + 1];
                    }
                    ranking[ranking.length - 1] = temp;
                    break;
                }
            }
        }

        // Mostrar los medallistas
        System.out.println("Medallistas:");
        if (ranking[0] != 0) {
            System.out.println("Oro: " + ranking[0]);
        }
        if (ranking.length > 1 && ranking[1] != 0) {
            System.out.println("Plata: " + ranking[1]);
        }
        if (ranking.length > 2 && ranking[2] != 0) {
            System.out.println("Bronce: " + ranking[2]);
        }

        sc.close();
    }
}

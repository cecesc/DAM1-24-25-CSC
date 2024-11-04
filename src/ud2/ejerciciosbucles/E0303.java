package ud2.ejerciciosbucles;

import java.util.Random;
import java.util.Scanner;

public class E0303 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1; // Número entre 1 y 100
        Scanner sc = new Scanner(System.in);
        int intento;
        int contadorIntentos = 0;

        System.out.println("Adivina el número secreto entre 1 y 100. Introduce -1 para rendirte.");

        do {
            System.out.print("Introduce tu intento: ");
            intento = sc.nextInt();
            contadorIntentos++;

            if (intento == -1) {
                System.out.println("Te has rendido. El número secreto era: " + numeroSecreto);
                break;
            }

            if (intento < numeroSecreto) {
                System.out.println("Mayor.");
            } else if (intento > numeroSecreto) {
                System.out.println("Menor.");
            } else {
                System.out.println("¡Correcto! Has adivinado el número secreto en " + contadorIntentos + " intentos.");
            }
        } while (intento != numeroSecreto);

        sc.close();
    }
}
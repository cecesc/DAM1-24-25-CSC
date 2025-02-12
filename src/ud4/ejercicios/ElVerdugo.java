package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ElVerdugo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la palabra secreta
        System.out.print("Ingrese la palabra secreta (o un punto '.' para terminar): ");
        String palabraSecreta = scanner.nextLine();

        // Terminar si se encuentra un punto
        if (palabraSecreta.equals(".")) {
            scanner.close();
            return;
        }

        // Leer las letras propuestas
        System.out.print("Ingrese las letras propuestas: ");
        String letrasPropuestas = scanner.nextLine();

        // Convertir la palabra secreta a un arreglo de caracteres
        char[] letrasSecretas = palabraSecreta.toCharArray();
        boolean[] letrasAdivinadas = new boolean[26]; // Para letras de 'a' a 'z'
        int fallos = 0;

        // Procesar las letras propuestas
        for (char letra : letrasPropuestas.toCharArray()) {
            // Ignorar letras repetidas
            if (letrasAdivinadas[letra - 'a']) {
                continue;
            }

            // Marcar la letra como adivinada
            letrasAdivinadas[letra - 'a'] = true;

            // Verificar si la letra está en la palabra secreta
            if (!palabraSecreta.contains(String.valueOf(letra))) {
                fallos++;
            }

            // Verificar si se ha alcanzado el límite de fallos
            if (fallos >= 7) {
                System.out.println("AHORCADO");
                return;
            }
        }

        // Verificar si se ha salvado
        boolean salvado = true;
        for (char letra : letrasSecretas) {
            if (!letrasAdivinadas[letra - 'a']) {
                salvado = false;
                break;
            }
        }

        if (salvado) {
            System.out.println("SALVADO");
        } else {
            System.out.println("COLGANDO");
        }

        scanner.close();
    }
}
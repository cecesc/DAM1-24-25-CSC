package ud2.ejerciciosbucles;

import java.util.Random;
import java.util.Scanner;

public class E0305 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int correctas = 0;
        boolean continuar = true;

        System.out.println("Bienvenido al juego de cálculo mental de sumas.");
        System.out.println("Introduce la solución de la suma de dos números aleatorios entre 1 y 100.");
        System.out.println("Escribe un número negativo para salir del juego.");

        while (continuar) {
            int num1 = random.nextInt(100) + 1; // Número entre 1 y 100
            int num2 = random.nextInt(100) + 1; // Número entre 1 y 100
            int sumaCorrecta = num1 + num2;

            System.out.print("¿Cuánto es " + num1 + " + " + num2 + "? ");
            int respuesta = sc.nextInt();

            if (respuesta < 0) {
                System.out.println("Has decidido salir del juego.");
                continuar = false;
            } else if (respuesta == sumaCorrecta) {
                correctas++;
                System.out.println("¡Correcto! Total de respuestas correctas: " + correctas);
            } else {
                System.out.println("Incorrecto. La respuesta correcta era: " + sumaCorrecta);
                continuar = false;
            }
        }

        System.out.println("Número de operaciones realizadas correctamente: " + correctas);
        sc.close();
    }
}
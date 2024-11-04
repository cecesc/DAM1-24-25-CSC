package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int altura;
        int maxAltura = -1;
        int etiquetaMaxima = -1;
        int contador = 0;

        do {
            System.out.print("Introduzca la altura del árbol (en cm, -1 para terminar): ");
            altura = sc.nextInt();

            if (altura != -1) {
                contador++;
                if (altura > maxAltura) {
                    maxAltura = altura;
                    etiquetaMaxima = contador - 1; // Etiqueta comienza en 0
                }
            }
        } while (altura != -1);

        if (maxAltura != -1) {
            System.out.println("El árbol más alto es el número " + etiquetaMaxima + " con una altura de " + maxAltura + " cm.");
        } else {
            System.out.println("No se introdujeron alturas válidas.");
        }

        sc.close();
    }
}
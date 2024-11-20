//Autor: Celia Sanmartín Chapela
package ud2.cscexamen;

import java.util.Scanner;

public class MenuFiguras {

    public static void main(String[] args) {
        int opcion;

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Triángulo");
        System.out.println("2. Rectángulo");
        System.out.println("0. SALIR");
        opcion = sc.nextInt();

        if (opcion > 0 && opcion < 2) {
            System.out.print("Opción inválida");
        } else {
            switch (opcion) {
                case 0:
                    System.out.println("Hasta luego!!");
                    break;
                case 1:
                    System.out.print("Introduzca un número entre 2 y 20: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.print("Introduzca un número entre 2 y 20 para la fila: \n");
                    int fila = sc.nextInt();
                    System.out.print("Introduzca un número entre 2 y 20 para la columna: ");
                    int columna = sc.nextInt();
                    for (int i = 0; i < fila; i++) {
                        for (int j = 0; j < columna; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
            }

            sc.close();
        }
    }

}

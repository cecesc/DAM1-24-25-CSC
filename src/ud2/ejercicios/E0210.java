/*Pedir una nota entera de 0 a 10 y mostrarla de la siguiente forma: insuficiente (de
0 a 4), suficiente (5), bien (6), notable (7 y 8) y sobresaliente (9 y 10).*/

package ud2.ejercicios;

import java.util.Scanner;

public class E0210 {
    public static void main(String[] args) {
        int nota;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca su nota (Sin decimales): ");
        nota = sc.nextInt();
        sc.close();

        switch (nota) {
            case 0: case 1: case 2: case 3: case 4:
                System.out.println("Insuficiente");
                break;
            case 5:
                System.out.println("Suficiente");
                break;
            case 6:
                System.out.println("Bien");
                break;
            case 7: case 8:
                System.out.println("Notable");
                break;
            case 9: case 10:
                System.out.println("Sobresaliente");
            default:
                System.out.println("Nota no válida. Introduce un valor entre 0 y 10.");
        }

    }

}

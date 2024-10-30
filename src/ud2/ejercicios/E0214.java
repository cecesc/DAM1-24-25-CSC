/* Crear una aplicación que solicite al usuario una fecha (día, mes, año) y muestre la
fecha correspondiente al día siguiente.*/

package ud2.ejercicios;

import java.util.Scanner;

public class E0214 {
    public static void main(String[] args) {
        int dia, mes, anho;
        int diasDelMes;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza un día: ");
        dia = sc.nextInt();
        System.out.print("Introduza un mes: ");
        mes = sc.nextInt();
        System.out.print("Introduza un año: ");
        anho = sc.nextInt();
        sc.close();

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            System.out.println(" La fecha es inválida");
        }
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
                diasDelMes = 31;
                break;

            case 2:
                diasDelMes = 28;
                break;

            case 4, 6, 9, 11:
                diasDelMes = 30;
                break;

            default:
                diasDelMes = 0;

        }
        if (dia < diasDelMes) {
            dia++;
        } else if (dia == diasDelMes) {
            dia = 1;
            if (mes == 12) {
                mes = 1;
                anho++;
            } else {
                mes++;
            }
        } else {
            System.out.println("Fecha inválida");
        }
        System.out.printf("El día siguiente es: %02d-%02d-%d%n", dia, mes, anho);

    }
}

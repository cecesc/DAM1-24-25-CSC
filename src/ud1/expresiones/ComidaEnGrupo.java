package ud1.expresiones;

import java.util.Scanner;

public class ComidaEnGrupo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Número de personas: ");
        int npersonas = scanner.nextInt();
        System.out.print("Importe total de la comida (€): ");
        double importe = scanner.nextDouble();
        scanner.close();

        double individual = importe / npersonas;

        System.out.printf("Cantidad a pagar por comensal: %.2f €", individual);


    }
}

package ud1.expresiones;

import java.util.Scanner;

public class EP0114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de horas");
        double numH = sc.nextDouble();
        System.out.println("Introduzca el numero de minutos");
        double numM = sc.nextDouble();
        System.out.println("Introduzca el numero de segundos");
        double numS = sc.nextDouble();
        sc.close();

        double converH = numH * 3600;
        double converM = numM * 60;

        double total = converH + converM + numS;

        System.out.printf("El total de segundos es %.2f", total);

    }

}

package ud1.expresiones;

import java.util.Scanner;

public class EP0115 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Introduzca el número total de segundos");
        int tsegundos = sc.nextInt();
        sc.close();

        int horas = tsegundos / 3600;
        int minutos = (tsegundos % 3600) / 60;
        int segundos = tsegundos % 60;

        
        System.out.println(tsegundos + " segundos son equivalentes a " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos.");

    }
    
}

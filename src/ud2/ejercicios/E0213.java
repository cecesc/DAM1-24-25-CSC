/*  Escribir un programa que pida una hora de la siguiente forma: hora, minutos y
segundos. El programa debe mostrar qué hora será un segundo más tarde. Por ejemplo:
hora actual (10:41:59) => hora actual + 1 segundo (10:42:00) */
package ud2.ejercicios;

import java.util.Scanner;

public class E0213 {
    public static void main(String[] args) {
        int segundos, minutos, horas;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza las horas: ");
        horas = sc.nextInt();
        System.out.print("Introduza los minutos: ");
        minutos = sc.nextInt();
        System.out.print("Introduza los segundos: ");
        segundos = sc.nextInt();
        sc.close();

        if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60) {
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                    if (horas == 24) {
                        horas = 0;
                    }
                }
            }
            System.out.println("La hora un segundo más tarde será " + horas + ":" + minutos + ":" + segundos);
        } else {
            System.out.println("Horas minutos o segundo inválidos");
        }

    }
}

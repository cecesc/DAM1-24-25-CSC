package ud1.ejercicios;

import java.util.Scanner;


public class EP0114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce número de horas: ");
        int nHoras = sc.nextInt();

        System.out.print("Introduce número de minutos: ");
        int nMinutos = sc.nextInt();

        System.out.print("Introduce número de segundos: ");
        int nSegundos = sc.nextInt();

int SgHo = nHoras*3600;
int SgMn = nMinutos*60;
int SgTotal=  SgHo + SgMn + nSegundos;

        System.out.println("El numero total de segundos es: " +SgTotal);
        sc.close();
    }
}

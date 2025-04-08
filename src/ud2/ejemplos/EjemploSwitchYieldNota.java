package ud2.ejemplos;

import java.util.Scanner;

public class EjemploSwitchYieldNota {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduzca una nota entera entre 0 y 10: ");
            int nota = sc.nextInt();
            sc.close();
            switch (nota) {
                case 0: System.out.println("Suspenso \n Ánimo!");
                case 1: System.out.println("Suspenso \n Ánimo!");
                case 2: System.out.println("Suspenso \n Ánimo!");
                case 3: System.out.println("Suspenso \n Ánimo!");
                case 4: System.out.println("Suspenso \n Ánimo!");
                case 5: System.out.println("Bien");
                case 6: System.out.println("Bien");
                case 7: System.out.println("Notable");
                case 8: System.out.println("Notable");
                case 9: System.out.println("Sobresaliente");
                case 10: System.out.println("Sobresaliente");
                default: System.out.println("Nota inválida");
        };

    }

}
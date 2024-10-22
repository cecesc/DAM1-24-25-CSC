package ud2.ejercicios;

import java.util.Scanner;

public class E0211 {
    public static void main(String[] args) {
        int numSemana;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el número correspondiente al día de la semana: ");
        numSemana = sc.nextInt();
        sc.close();

        switch (numSemana) {
            case 1:
                System.out.println("El número " +numSemana + " corresponde al lunes");
                break;
            case 2:
                System.out.println("El número " +numSemana + " corresponde al martes");
                break;
            case 3:
                System.out.println("El número " +numSemana + " corresponde al miércoles");
                break;
            case 4:
                System.out.println("El número " +numSemana + " corresponde al jueves");
                break; 
            case 5:
                System.out.println("El número " +numSemana + " corresponde al viernes");
                break; 
            case 6:
                System.out.println("El número " +numSemana + " corresponde al sábado");
                break;
            case 7:
                System.out.println("El número " +numSemana + " corresponde al domingo");
                break;
            default:
                System.out.println("El número introducido no es correcto");
        }
    }

}

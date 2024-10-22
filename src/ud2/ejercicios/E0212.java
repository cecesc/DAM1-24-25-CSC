package ud2.ejercicios;

import java.util.Scanner;

public class E0212 {
    public static void main(String[] args) {
        int dia, mes, anho;
        boolean fechaValida = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza un día: ");
        dia = sc.nextInt();
        System.out.print("Introduza un día: ");
        mes = sc.nextInt();
        System.out.print("Introduza un día: ");
        anho = sc.nextInt();
        sc.close();

        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (dia < 1 || dia > 31) {
                    fechaValida = false;
                }
                break;
            case 4: case 6: case 9: case 11:
                if (dia < 1 || dia > 30) {
                    fechaValida = false;
                }
                break;
            case 2:
                if (dia < 1 || dia > 28) {
                    fechaValida = false;
                }
                break;
            default:
                fechaValida = false;
        }
        
        
        if (fechaValida) {
            System.out.println("La fecha es válida: " + dia + "/" + mes + "/" + anho);
        } else {
            System.out.println("La fecha es incorrecta.");
        }


    }
}

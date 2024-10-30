package ud1.ejercicios.csc20241010;

import java.util.Scanner;

public class EP0129 {

    public static void main(String[] args) {
        int numero;
        int restoDivision;
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        numero = sc.nextInt();
        sc.close();

        restoDivision = numero % 7;

        int suma = (restoDivision == 0) ? 0 : (7 - restoDivision);

        System.out.println("A " + numero + " hay que sumarle " + suma + " para que sea múltiplo de 7");
    }
}

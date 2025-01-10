package ud4.arraysejercicios;
import java.util.Scanner;

public class EjArrays05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int positivos = 0, negativos = 0, ceros = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = sc.nextInt();
        }

        for (int num : numeros) {
            if (num > 0) {
                positivos++;
            } else if (num < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    
        sc.close();
    }
}
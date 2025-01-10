package ud4.arraysejercicios;
import java.util.Scanner;

public class EjArrays06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        double sumaPositivos = 0, sumaNegativos = 0;
        int contadorPositivos = 0, contadorNegativos = 0;

        for (int i =  0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = sc.nextInt();
        }

        for (int num : numeros) {
            if (num > 0) {
                sumaPositivos += num;
                contadorPositivos++;
            } else if (num < 0) {
                sumaNegativos += num;
                contadorNegativos++;
            }
        }

        double mediaPositivos = contadorPositivos > 0 ? sumaPositivos / contadorPositivos : 0;
        double mediaNegativos = contadorNegativos > 0 ? sumaNegativos / contadorNegativos : 0;

        System.out.println("La media de los valores positivos es: " + mediaPositivos);
        System.out.println("La media de los valores negativos es: " + mediaNegativos);
    
    sc.close();
    }
}
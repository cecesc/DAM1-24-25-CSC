import java.util.Scanner;

public class EjArrays02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        double suma = 0;
        int contador = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i += 2) {
            suma += numeros[i];
            contador++;
        }

        double media = suma / contador;
        System.out.println("La media de los números en posiciones pares es: " + media);
    }
}
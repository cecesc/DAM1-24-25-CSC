package ud4.arraysejercicios;
import java.util.Scanner;

public class EjArrays10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int suma = 0;

        System.out.println("Introduce los elementos de la matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
                suma += matriz[i][j];
            }
        }

        System.out.println("La suma de todos los elementos de la matriz es: " + suma);
    }
}
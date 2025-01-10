import java.util.Scanner;

public class EjArrays03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos alumnos hay en la clase? ");
        int n = scanner.nextInt();
        double[] notas = new double[n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            suma += notas[i];
        }

        double media = suma / n;
        System.out.println("La nota media del grupo es: " + media);
        System.out.println("Alumnos con notas superiores a la media:");

        for (int i = 0; i < n; i++) {
            if (notas[i] > media) {
                System.out.println("Alumno " + (i + 1) + ": " + notas[i]);
            }
        }
    }
}
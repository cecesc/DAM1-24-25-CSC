import java.util.Scanner;

public class EjArrays01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos números quieres introducir? ");
        int n = scanner.nextInt();
        double suma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Introduce un número: ");
            suma += scanner.nextDouble();
        }

        double media = suma / n;
        System.out.println("La media es: " + media);
    }
}
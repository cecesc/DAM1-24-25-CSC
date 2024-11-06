package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0315 {
    public static void main(String[] args) {
        int numero; // declaración de variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número");
        numero = sc.nextInt();
        sc.close();

        // proceso & salida
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}

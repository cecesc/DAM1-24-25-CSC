package ud4;

import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el título: ");
        String titulo = sc.nextLine();
        titulo = "<p>"+ titulo + "</p>";
        System.out.println(titulo);
        sc.close();
    }
}

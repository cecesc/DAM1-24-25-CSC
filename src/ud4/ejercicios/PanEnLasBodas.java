package ud4.ejercicios;

import java.util.Scanner;

public class PanEnLasBodas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada
        System.out.println("Ingrese el número de sillas y la disposición (ej. 5 I.D..):");
        String entrada = scanner.nextLine();

        // Procesar la entrada
        if (!entrada.isEmpty()) {
            String[] partes = entrada.split(" ");
            int n = Integer.parseInt(partes[0]);
            String mesa = partes[1];

            boolean todosComen = true;

            // Verificar cada silla
            for (int i = 0; i < n; i++) {
                if (mesa.charAt(i) == '.') {
                    // Verificar los vecinos
                    char izquierda = mesa.charAt((i - 1 + n) % n); // Silla a la izquierda
                    char derecha = mesa.charAt((i + 1) % n); // Silla a la derecha

                    if (izquierda == 'I' && derecha == 'D') {
                        todosComen = false;
                        break; // Al menos uno no puede comer
                    }
                }
            }

            // Imprimir el resultado
            if (todosComen) {
                System.out.println("TODOS COMEN");
            } else {
                System.out.println("ALGUNO NO COME");
            }
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class ConcursoSimetrias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer caso de prueba
        System.out.print("Ingrese el ancho y alto de la figura (0 0 para terminar): ");
        int tx = scanner.nextInt(); // Ancho
        int ty = scanner.nextInt(); // Alto

        // Continuar mientras no se reciba 0 0
        while (tx != 0 && ty != 0) {
            char[][] figura = new char[ty][tx];

            // Leer la figura
            System.out.println("Ingrese la figura:");
            for (int i = 0; i < ty; i++) {
                figura[i] = scanner.next().toCharArray();
            }

            // Verificar simetría
            boolean esCorrecto = verificarSimetria(figura, tx, ty);
            System.out.println(esCorrecto ? "CORRECTO" : "TRAMPOSO");

            // Leer el siguiente caso de prueba
            System.out.print("Ingrese el ancho y alto de la figura (0 0 para terminar): ");
            tx = scanner.nextInt(); // Ancho
            ty = scanner.nextInt(); // Alto
        }

        scanner.close(); // Cerrar el escáner al final
    }

    private static boolean verificarSimetria(char[][] figura, int tx, int ty) {
        // Verificar simetría vertical
        for (int i = 0; i < ty; i++) {
            for (int j = 0; j < tx / 2; j++) {
                if (figura[i][j] != figura[i][tx - 1 - j]) {
                    return false; // No es simétrica verticalmente
                }
            }
        }

        // Verificar simetría horizontal
        for (int j = 0; j < tx; j++) {
            for (int i = 0; i < ty / 2; i++) {
                if (figura[i][j] != figura[ty - 1 - i][j]) {
                    return false; // No es simétrica horizontalmente
                }
            }
        }

        return true; // Es simétrica
    }
}
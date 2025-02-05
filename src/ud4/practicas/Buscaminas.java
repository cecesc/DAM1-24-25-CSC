package ud4.practicas;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    static final int FILAS = 5;
    static final int COLUMNAS = 5;
    static final int NUM_MINAS = 4;
    static boolean[][] tableroMinas = new boolean[FILAS][COLUMNAS];
    static char[][] tableroJuego = new char[FILAS][COLUMNAS];
    static int numMarcas = 0;
    static boolean Salir = false;
    static boolean minaDest = false;
    static boolean minasMarc = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarTableroMinas();
        iniciarTableroJuego();
        int opcion, fila, columna;

        do {
            imprimirTableroJuego();
            imprimirMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 0:
                    Salir = true;
                    break;
                case 1:
                    fila = leerFila();
                    columna = leerColumna();
                    destaparCasilla(fila, columna);
                    break;
                case 2:
                    fila = leerFila();
                    columna = leerColumna();
                    marcarCasilla(fila, columna);
                    break;
                case 3:
                    fila = leerFila();
                    columna = leerColumna();
                    desmarcarCasilla(fila, columna);
                    break;
            }
        } while (!Salir && !minaDest && !minasMarc);
        imprimirFinJuego();
    }

    static void iniciarTableroMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < NUM_MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);
            if (!tableroMinas[fila][columna]) {
                tableroMinas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    static void iniciarTableroJuego() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroJuego[i][j] = '-';
            }
        }
    }

    static void imprimirTableroJuego() {
        System.out.println("Tablero:");
        for (char[] fila : tableroJuego) {
            for (char casilla : fila) {
                System.out.print(casilla + " ");
            }
            System.out.println();
        }
    }

    static void imprimirMenu() {
        System.out.println("\n1. Destapar casilla");
        System.out.println("2. Marcar casilla");
        System.out.println("3. Desmarcar casilla");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    static int leerOpcion() {
        return sc.nextInt();
    }

    static int leerFila() {
        System.out.print("Ingresa la fila: ");
        return sc.nextInt();
    }

    static int leerColumna() {
        System.out.print("Ingresa la columna: ");
        return sc.nextInt();
    }

    static void destaparCasilla(int fila, int columna) {
        if (tableroMinas[fila][columna]) {
            minaDest = true;
            System.out.println("¡Has pisado una mina! Fin del juego.");
        } else {
            tableroJuego[fila][columna] = '0'; // Simplificado para ahora
        }
    }

    static void marcarCasilla(int fila, int columna) {
        tableroJuego[fila][columna] = 'M';
    }

    static void desmarcarCasilla(int fila, int columna) {
        tableroJuego[fila][columna] = '-';
    }

    static void imprimirFinJuego() {
        System.out.println("Fin del juego.");
    }
}

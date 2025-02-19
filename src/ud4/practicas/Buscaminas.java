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
    static boolean opcionSalir = false; 
    static boolean minaDestapada = false; 
    static boolean minasMarcadas = false; 
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion, fila, columna;
        iniciarTableroMinas();
        iniciarTableroJuego();
        
        do {
            imprimirTableroJuego();
            imprimirMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 0:
                    opcionSalir = true;
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
        } while (!opcionSalir && !minaDestapada && !minasMarcadas);
        
        imprimirFinJuego();
        sc.close(); 
    }

    static void iniciarTableroMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < NUM_MINAS) {
            int fila = rand.nextInt(FILAS);
            int columna = rand.nextInt(COLUMNAS);
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
        System.out.println("Tablero de Juego:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tableroJuego[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void imprimirMenu() {
        System.out.println("Opciones:");
        System.out.println("0. Salir");
        System.out.println("1. Destapar Casilla");
        System.out.println("2. Marcar Casilla");
        System.out.println("3. Desmarcar Casilla");
    }

    static int leerOpcion() {
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    static int leerFila() {
        System.out.print("Ingrese la fila (0-" + (FILAS - 1) + "): ");
        return sc.nextInt();
    }

    static int leerColumna() {
        System.out.print("Ingrese la columna (0-" + (COLUMNAS - 1) + "): ");
        return sc.nextInt();
    }

    static void destaparCasilla(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }
        if (tableroMinas[fila][columna]) {
            minaDestapada = true;
            System.out.println("¡Has destapado una mina! Fin del juego.");
        } else {
            int minasAdyacentes = contarMinasAdyacentes(fila, columna);
            tableroJuego[fila][columna] = (char) ('0' + minasAdyacentes);
            if (minasAdyacentes == 0) {
                destaparCasillasAdyacentes(fila, columna);
            }
        }
    }

    static int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < FILAS && nuevaColumna >= 0 && nuevaColumna < COLUMNAS) {
                    if (tableroMinas[nuevaFila][nuevaColumna]) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    static void destaparCasillasAdyacentes(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; 
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < FILAS && nuevaColumna >= 0 && nuevaColumna < COLUMNAS) {
                    if (tableroJuego[nuevaFila][nuevaColumna] == '-') {
                        destaparCasilla(nuevaFila, nuevaColumna);
                    }
                }
            }
        }
    }

    static void marcarCasilla(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }
        if (tableroJuego[fila][columna] == '-') {
            tableroJuego[fila][columna] = 'M';
            numMarcas++;
        } else {
            System.out.println("Casilla ya destapada o marcada.");
        }
    }

    static void desmarcarCasilla(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }
        if (tableroJuego[fila][columna] == 'M') {
            tableroJuego[fila][columna] = '-';
            numMarcas--;
        } else {
            System.out.println("Casilla no está marcada.");
        }
    }

    static void imprimirFinJuego() {
        if (minaDestapada) {
            System.out.println("Juego terminado. Has perdido.");
        } else if (minasMarcadas) {
            System.out.println("¡Felicidades! Has ganado.");
        } else {
            System.out.println("Juego terminado. Has salido.");
        }
    }
}
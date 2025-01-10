import java.util.Scanner;

public class EjArrays11 {
    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';

    public static void main(String[] args) {
        iniciarTablero();
        boolean victoria = false;

        while (!victoria && !tableroLleno()) {
            mostrarTablero();
            leerMovimiento();
            victoria = comprobarVictoria();
            cambiarJugador();
        }

        mostrarTablero();
        if (victoria) {
            System.out.println("¡El jugador " + (jugadorActual == 'X' ? 'O' : 'X') + " ha ganado!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    private static void iniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private static void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void leerMovimiento() {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;
        do {
            System.out.print("Jugador " + jugadorActual + ", introduce fila (0-2) y columna (0-2): ");
            fila = scanner.nextInt();
            columna = scanner.nextInt();
        } while (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != '-');
        tablero[fila][columna] = jugadorActual;
    }

    private static boolean comprobarVictoria() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true; // Fila
            }
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true; // Columna
            }
        }
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true; // Diagonal
        }
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true; // Diagonal inversa
        }
        return false;
    }

    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
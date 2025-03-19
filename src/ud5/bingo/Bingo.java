package ud5.bingo;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    static final int MAX_NUM = 99;
    static Jugador[] jugadores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBINGO");
        System.out.println("=====\n");

        System.out.print("Número de jugadores: ");
        int numJugadores = sc.nextInt();
        jugadores = new Jugador[numJugadores];

        System.out.println("\nIntroduce los datos de los jugadores:");

        for (int i = 1; i <= numJugadores; i++) {
            sc.nextLine(); // Limpio el buffer de entrada de teclado
            System.out.print("Nombre jugador" + i + ": ");
            String nombre = sc.nextLine();
            System.out.print("Número de cartones: ");
            int numCartones = sc.nextInt();
            System.out.println();

            Jugador jugador = new Jugador(nombre, numCartones);
            jugadores[i - 1] = jugador;
            System.out.println(jugador);
        }

        // Comienza el Juego
        System.out.println("Comienza el juego");
        System.out.println("-----------------");
        // Dos Modalidades
        System.out.println("Que modalidad prefieres? (N - Número a número)  (A - Automática)");
        int opcion = sc.nextLine().toUpperCase().charAt(0);
        switch (opcion) {
            case 'N':
                modoNumeroANumero();
                break;
            case 'A':
                modoAutomatico();
                break;
            default:
                System.out.println("Opción incorrecta. Fin del programa");
        }
    }

    private static void modoAutomatico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modoAutomatico'");
    }

    private static void modoNumeroANumero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modoNumeroANumero'");
    }
}

class Jugador {
    String nombre;
    Carton[] cartones;

    public Jugador(String nombre, int numCartones) {
        this.nombre = nombre;
        // TODO Instanciar cartones
        cartones = new Carton[numCartones];
        for (int i = 0; i < cartones.length; i++) {
            cartones[i] = new Carton();
        }
    }

    @Override
    public String toString() {
        String str = "Jugador: " + nombre + " (" + cartones.length + " cartones)\n\n";
        for (int i = 0; i < cartones.length; i++) {
            str += cartones[i] + "\n";
        }
        return str;
    }
}

class Carton {
    static final int MAX_FILAS = 3;
    static final int MAX_COLS = 5;

    int[][] numeros;

    public Carton() {
        this.numeros = new int[MAX_FILAS][MAX_COLS];
        // Rellenar con números aleatorios distintos.
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                // Genera un número aleatorio
                Random rnd = new Random();
                // TODO Comprobar que el número no está repetido
                numeros[i][j] = rnd.nextInt(Bingo.MAX_NUM) + 1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                str.append(numeros[i][j] + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    

}

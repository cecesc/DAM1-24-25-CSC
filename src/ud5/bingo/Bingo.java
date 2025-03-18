package ud5.bingo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    static final int MAX_NUM = 99;
    static Jugador[] jugadores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n BINGO");
        System.out.println("==========");

        System.out.println("Número de jugadores: ");
        int numjugadores = sc.nextInt();
        jugadores = new Jugador[numjugadores];

        System.out.println("Introduce los datos de los jugadores: ");

        for (int i = 1; i <= numjugadores; i++) {
            sc.nextLine();
            System.out.println("Nombrejugador" + i + ": ");
            String nombre = sc.nextLine();
            System.out.println("Número de cartones: ");
            int numcartones = sc.nextInt();
            System.out.println();

            Jugador jugador = new Jugador(nombre, numcartones);
            jugadores[i - 1] = jugador;
            System.out.println(jugador);
        }

        System.out.println("Comienza el juego");
        System.out.println("-----------------");
        System.out.println("Que modalidad prefieres ( N - NÚMERO A NÚMERO) (A - AUTOMÁTICA)");
        int opcion = sc.nextLine().toUpperCase().charAt(0);
        switch (opcion) {
            case 'N':
                modoNumeroANunero();
                break;

            case 'A':
                modoAutomático();
                break;
        }
    }

}

class Jugador {
    String nombre;
    Carton[] cartones;

    public Jugador(String nombre, int numcartones) {
        this.nombre = nombre;

        for (int i = 0; i < cartones.length; i++) {
            cartones[1] = new Carton();
        }

    }

    @Override
    public String toString() {
        return "Jugador " + nombre + "( " + cartones.length + "Cartones)";
    }
}

class Carton {
    static final int MAX_FILA = 3;
    static final int MAX_COLS = 5;

    int[][] numeros;

    public Carton() {
        this.numeros = new int[MAX_FILA][MAX_COLS];
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLS; j++) {

                Random rdn = new Random();
                int num = rdn.nextInt(Bingo.MAX_NUM) + 1;

            }

        }

    }

}

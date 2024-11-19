package ud2.practicas;

public class CalculadoraHumana {
    public static void main(String[] args) {
        int MAX_ACIERTOS = 7;
        int VALOR_MAX_OPERANDO = 200;
        int num_aciertos = 0;
        int num_intentos = 0;
        int operando1, operando2, operador;

        // Inicialización del Juego
        // Genera el primer número aleatorio entre 2 y 200
        operando1 = random(2, 200);

        // Bucle principal del Juego
        while (num_aciertos < MAX_ACIERTOS) {

        }

        // Fin del Juego
    }

    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}


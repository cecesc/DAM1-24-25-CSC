package ud4.arraysejercicios;
import java.util.Random;

public class EjArrays09 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numerosAleatorios = new int[10];

        for (int i = 0; i < 10; i++) {
            numerosAleatorios[i] = random.nextInt(100); // Números aleatorios entre 0 y 99
        }

        System.out.println("Números aleatorios generados:");
        for (int num : numerosAleatorios) {
            System.out.print(num + " ");
        }
    }
}
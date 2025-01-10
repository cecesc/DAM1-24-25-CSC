package ud4.arraysejercicios;
import java.util.Random;

public class EP0513 {
    public static int[] desordenar(int[] t) {
        int[] copia = t.clone(); // Crear una copia del array
        Random rand = new Random();
        for (int i = 0; i < copia.length; i++) {
            int j = rand.nextInt(copia.length);
            // Intercambiar elementos
            int temp = copia[i];
            copia[i] = copia[j];
            copia[j] = temp;
        }
        return copia;
    }

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5};
        int[] desordenado = desordenar(t);
        System.out.println("Array original: " + java.util.Arrays.toString(t));
        System.out.println("Array desordenado: " + java.util.Arrays.toString(desordenado));
    }
}
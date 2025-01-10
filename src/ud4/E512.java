import java.util.Random;

public class EP0512 {
    public static void desordenar(int[] t) {
        Random rand = new Random();
        for (int i = 0; i < t.length; i++) {
            int j = rand.nextInt(t.length);
            // Intercambiar elementos
            int temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5};
        desordenar(t);
        System.out.println("Array desordenado: " + java.util.Arrays.toString(t));
    }
}
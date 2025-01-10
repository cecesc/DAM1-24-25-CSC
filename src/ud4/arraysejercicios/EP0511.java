package ud4.arraysejercicios;
import java.util.ArrayList;

public class EP0511 {
    public static int[] buscarTodos(int[] t, int clave) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                indices.add(i);
            }
        }
        return indices.stream().mapToInt(i -> i).toArray(); // Convertir a array
    }

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 2, 4, 2};
        int clave = 2;
        int[] indices = buscarTodos(t, clave);
        System.out.println("Indices de la clave " + clave + ": " + java.util.Arrays.toString(indices));
    }
}
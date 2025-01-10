package ud4.arraysejercicios;

public class EP0517 {
    public static int[] suma(int[] t, int numElementos) {
        if (t == null || t.length < numElementos || numElementos <= 0) {
            return new int[0]; // Manejo de casos inválidos
        }

        int[] resultado = new int[t.length - numElementos + 1];
        for (int i = 0; i <= t.length - numElementos; i++) {
            int suma = 0;
            for (int j = 0; j < numElementos; j++) {
                suma += t[i + j];
            }
            resultado[i] = suma;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] t = {10, 1, 5, 8, 9, 2};
        int numElementos = 3;
        int[] sumas = suma(t, numElementos);
        System.out.println("Sumas de " + numElementos + " elementos: " + java.util.Arrays.toString(sumas));
    }
}
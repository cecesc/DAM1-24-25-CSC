package ud4.arraysejercicios;
public class EjArrays04 {
    public static void main(String[] args) {
        int[] pares = new int[20];

        for (int i = 0; i < 20; i++) {
            pares[i] = i * 2;
        }

        System.out.println("Los primeros 20 números pares son:");
        for (int par : pares) {
            System.out.print(par + " ");
        }
    }
}
public class EP0520 {
    public static int[] fusionOrdenada(int[] t1, int[] t2) {
        if (t1 == null || t2 == null) {
            return new int[0]; // Manejo de casos nulos
        }

        int[] fusion = new int[t1.length + t2.length];
        int i = 0, j = 0, k = 0;

        while (i < t1.length && j < t2.length) {
            if (t1[i] <= t2[j]) {
                fusion[k++] = t1[i++];
            } else {
                fusion[k++] = t2[j++];
            }
        }

        while (i < t1.length) {
            fusion[k++] = t1[i++];
        }

        while (j < t2.length) {
            fusion[k++] = t2[j++];
        }

        return fusion;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 3, 5, 7};
        int[] t2 = {2, 4, 6, 8};
        int[] fusion = fusionOrdenada(t1, t2);
        System.out.println("Fusión de tablas ordenadas: " + java.util.Arrays.toString(fusion));
    }
}
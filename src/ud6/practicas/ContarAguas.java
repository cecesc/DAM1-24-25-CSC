package ud6.practicas;
public class ContarAguas {

    public static int calcularAuga(int[] bloques) {
        if (bloques == null || bloques.length < 3) return 0;

        int n = bloques.length;
        int[] maxIzq = new int[n];
        int[] maxDech = new int[n];
        int totalAuga = 0;

        // Máximos hacia la izquierda
        maxIzq[0] = bloques[0];
        for (int i = 1; i < n; i++) {
            maxIzq[i] = Math.max(maxIzq[i - 1], bloques[i]);
        }

        // Máximos hacia la derecha
        maxDech[n - 1] = bloques[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxDech[i] = Math.max(maxDech[i + 1], bloques[i]);
        }

        // Calcular agua atrapada
        for (int i = 0; i < n; i++) {
            int nivelAuga = Math.min(maxIzq[i], maxDech[i]) - bloques[i];
            if (nivelAuga > 0) {
                totalAuga += nivelAuga;
            }
        }

        return totalAuga;
    }

    public static void debuxarAuga(int[] bloques) {
        if (bloques == null || bloques.length < 3) {
            System.out.println("Array inválido.");
            return;
        }

        int n = bloques.length;
        int alturaMax = 0;
        for (int h : bloques) alturaMax = Math.max(alturaMax, h);

        // Recalcular agua atrapada por posición
        int[] maxIzq = new int[n];
        int[] maxDech = new int[n];
        int[] agua = new int[n];

        maxIzq[0] = bloques[0];
        for (int i = 1; i < n; i++) {
            maxIzq[i] = Math.max(maxIzq[i - 1], bloques[i]);
        }
        maxDech[n - 1] = bloques[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxDech[i] = Math.max(maxDech[i + 1], bloques[i]);
        }

        for (int i = 0; i < n; i++) {
            int nivelAuga = Math.min(maxIzq[i], maxDech[i]) - bloques[i];
            agua[i] = Math.max(0, nivelAuga);
        }

        // Altura total visible (bloques + agua)
        int alturaVisual = 0;
        for (int i = 0; i < n; i++) {
            alturaVisual = Math.max(alturaVisual, bloques[i] + agua[i]);
        }

        // Dibujar desde arriba hacia abajo
        for (int h = alturaVisual; h > 0; h--) {
            System.out.print("| ");
            for (int i = 0; i < n; i++) {
                if (bloques[i] >= h) {
                    System.out.print("X ");
                } else if (bloques[i] + agua[i] >= h) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        int[] exemplo = {4, 0, 3, 6, 1, 3}; // Debería dar 7 unidades de auga
        int resultado = calcularAuga(exemplo);
        System.out.println("Total auga acumulada: " + resultado);
        debuxarAuga(exemplo);
    }
}

package ud6.ejercicios;

import java.util.Scanner;

public class CumpleanhosRepetidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n == 0) break;

            String[] fechas = sc.nextLine().split(" ");
            boolean hayRepetido = false;

            for (int i = 0; i < n && !hayRepetido; i++) {
                String diaMes = obtenerDiaMes(fechas[i]);
                for (int j = i + 1; j < n; j++) {
                    if (diaMes.equals(obtenerDiaMes(fechas[j]))) {
                        hayRepetido = true;
                        break;
                    }
                }
            }

            System.out.println(hayRepetido ? "SI" : "NO");
        }

        sc.close();
    }

    static String obtenerDiaMes(String fecha) {
        String[] partes = fecha.split("/");
        return partes[0] + "/" + partes[1]; // solo día y mes
    }
}


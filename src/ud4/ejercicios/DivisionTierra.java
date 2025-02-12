package ud4.ejercicios;

import java.util.Scanner;

public class DivisionTierra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el grado del polinomio
        System.out.println("Ingrese el grado del polinomio (20 para terminar):");
        int grado = scanner.nextInt();

        while (grado != 20) {
            // Leer los coeficientes del polinomio
            int[] coeficientes = new int[grado + 1];
            System.out.println("Ingrese los coeficientes del polinomio:");
            for (int i = 0; i <= grado; i++) {
                coeficientes[i] = scanner.nextInt(); // Leer el coeficiente
            }

            System.out.println("Ingrese el número de rectángulos:");
            int n = scanner.nextInt(); // Número de rectángulos
            double areaCain = 0.0;
            double base = 1.0 / n;

            // Calcular el área bajo la curva usando la suma de Riemann
            for (int i = 0; i < n; i++) {
                double x = i * base; // x en el punto izquierdo del rectángulo
                double f_x = evaluatePolynomial(coeficientes, x); // Evaluar el polinomio

                // Ajustar el área según el valor de f(x)
                if (f_x < 0) {
                    f_x = 0; // No sumar área negativa
                } else if (f_x > 1) {
                    f_x = 1; // No sumar más de 1 hectárea
                }

                areaCain += base * f_x; // Área del rectángulo
            }

            double areaAbel = 1.0 - areaCain; // Total es 1 hectárea

            // Comparar áreas
            double diferencia = Math.abs(areaCain - areaAbel);
            if (diferencia <= 0.001) {
                System.out.println("JUSTO");
            } else if (areaCain > areaAbel) {
                System.out.println("CAIN");
            } else {
                System.out.println("ABEL");
            }

            // Leer el siguiente grado del polinomio
            System.out.println("Ingrese el grado del polinomio (20 para terminar):");
            grado = scanner.nextInt();
        }

        scanner.close();
    }

    // Método para evaluar el polinomio en un punto x
    private static double evaluatePolynomial(int[] coeficientes, double x) {
        double result = 0.0;
        for (int i = 0; i < coeficientes.length; i++) result += coeficientes[i] * Math.pow(x, coeficientes.length - 1 - i);

        return result;
}
}
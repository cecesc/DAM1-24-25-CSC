package ud4.ejercicios;

import java.util.Scanner;

public class EligiendoCaramelos {
    private static final int MOD = 1000000007;
    private static long[] factorial;
    private static long[] inverseFactorial;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Precomputar factoriales y sus inversos
        int maxN = 5000;
        factorial = new long[maxN + 1];
        inverseFactorial = new long[maxN + 1];

        factorial[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        inverseFactorial[maxN] = modInverse(factorial[maxN]);
        for (int i = maxN - 1; i >= 0; i--) {
            inverseFactorial[i] = inverseFactorial[i + 1] * (i + 1) % MOD;
        }

        // Leer los casos de prueba
        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n == 0 && m == 0) {
                break; // Terminar si se encuentra "0 0"
            }

            StringBuilder result = new StringBuilder();
            for (int k = 0; k <= m; k++) {
                long combinations = combination(n, k);
                result.append(combinations).append(" ");
            }
            System.out.println(result.toString().trim());
        }

        scanner.close();
    }

    private static long combination(int n, int k) {
        if (k > n || k < 0) {
            return 0;
        }
        return factorial[n] * inverseFactorial[k] % MOD * inverseFactorial[n - k] % MOD;
    }

    private static long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
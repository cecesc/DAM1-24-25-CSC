package ud4.ejercicios;

import java.util.Scanner;

public class PruebaDelNueve {

    // Método para calcular el resumen de un número en una base dada
    public static int calcularResumen(String numero, int base) {
        int suma = 0;
        for (char c : numero.toCharArray()) {
            int digito = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
            suma += digito;
            // Mantener la suma dentro de los límites de la base
            while (suma >= base) {
                suma -= base;
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de casos de prueba: ");
        int casosPrueba = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < casosPrueba; i++) {
            System.out.print("Ingrese la base, dividendo, divisor, cociente y resto (separados por espacios): ");
            String[] entrada = scanner.nextLine().split(" ");
            int base = Integer.parseInt(entrada[0]);
            String dividendo = entrada[1];
            String divisor = entrada[2];
            String cociente = entrada[3];
            String resto = entrada[4];

            // Calcular los resúmenes
            int resumenDividendo = calcularResumen(dividendo, base);
            int resumenDivisor = calcularResumen(divisor, base);
            int resumenCociente = calcularResumen(cociente, base);
            int resumenResto = calcularResumen(resto, base);

            // Verificar la relación D = d * c + r
            int resultadoEsperado = (resumenDivisor * resumenCociente + resumenResto) % (base - 1);
            if (resultadoEsperado == resumenDividendo) {
                System.out.println("POSIBLEMENTE CORRECTO");
            } else {
                System.out.println("INCORRECTO");
            }
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class MultiplicandoMal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer las parejas de números
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break; // Terminar si se encuentra una línea vacía
            }

            String[] partes = line.split(" ");
            String num1 = partes[0]; // Primer número
            String num2 = partes[1]; // Segundo número

            // Resultado de la multiplicación "mal"
            String[] resultados = new String[num2.length()];

            // Multiplicar cada dígito del segundo número por el primer número
            for (int i = 0; i < num2.length(); i++) {
                int digito = Character.getNumericValue(num2.charAt(num2.length() - 1 - i)); // Obtener el dígito
                String resultado = multiplicarPorDigito(num1, digito);
                // Alinear el resultado según la posición del dígito
                resultados[i] = resultado + "0".repeat(i); // Agregar ceros a la derecha
            }

            // Sumar los resultados
            String resultadoFinal = sumarResultados(resultados);

            // Imprimir el resultado
            System.out.println(resultadoFinal);
        }

        scanner.close();
    }

    // Método para multiplicar un número por un dígito
    private static String multiplicarPorDigito(String num, int digito) {
        if (digito == 0) {
            return "0"; // Si el dígito es 0, el resultado es 0
        }

        StringBuilder resultado = new StringBuilder();
        int carry = 0; // Llevar

        // Multiplicar cada dígito del número
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(num.charAt(i));
            int prod = n * digito + carry;
            resultado.append(prod % 10); // Agregar el dígito menos significativo
            carry = prod / 10; // Actualizar el llevar
        }

        // Agregar el llevar restante
        if (carry > 0) {
            resultado.append(carry);
        }

        // Invertir el resultado y convertir a String
        return resultado.reverse().toString();
    }

    // Método para sumar los resultados alineados
    private static String sumarResultados(String[] resultados) {
        String resultadoFinal = "0"; // Inicializar el resultado final

        for (String resultado : resultados) {
            resultadoFinal = sumarDosNumeros(resultadoFinal, resultado);
        }

        return resultadoFinal;
    }

    // Método para sumar dos números en formato String
    private static String sumarDosNumeros(String num1, String num2) {
        StringBuilder resultado = new StringBuilder();
        int carry = 0; // Llevar

        // Asegurarse de que num1 sea el más largo
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Sumar de derecha a izquierda
        for (int i = 0; i < num1.length(); i++) {
            int n1 = Character.getNumericValue(num1.charAt(num1.length() - 1 - i));
            int n2 = (i < num2.length()) ? Character.getNumericValue(num2.charAt(num2.length() - 1 - i)) : 0;
            int sum = n1 + n2 + carry;
            resultado.append(sum % 10); // Agregar el dígito menos significativo
            carry = sum / 10; // Actualizar el llevar
        }

        // Agregar el llevar restante
        if (carry > 0) {
            resultado.append(carry);
        }

        // Invertir el resultado y convertir a String
        return resultado.reverse().toString();
    }
}
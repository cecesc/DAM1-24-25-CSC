package ud4.ejercicios;

import java.util.Scanner;

public class CuantasMeLlevo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine(); // Leer la línea de entrada
            if (input.equals("0 0")) {
                break; // Terminar si se recibe "0 0"
            }

            String[] numeros = input.split(" "); // Separar los dos números
            String num1 = numeros[0];
            String num2 = numeros[1];

            // Contar acarreos
            int acarreoCount = contarAcarreos(num1, num2);
            System.out.println(acarreoCount);
        }

        scanner.close(); // Cerrar el escáner al final
    }

    private static int contarAcarreos(String num1, String num2) {
        int acarreoCount = 0;
        int carry = 0; // Variable para llevar el acarreo

        // Alinear los números por la derecha
        int maxLength = Math.max(num1.length(), num2.length());

        // Sumar dígito por dígito desde la derecha
        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length()) ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int digit2 = (i < num2.length()) ? num2.charAt(num2.length() - 1 - i) - '0' : 0;

            int sum = digit1 + digit2 + carry; // Sumar los dígitos y el acarreo
            if (sum >= 10) {
                acarreoCount++; // Hay acarreo
                carry = 1; // Actualizar el acarreo
            } else {
                carry = 0; // No hay acarreo
            }
        }

        return acarreoCount; // Retornar el número de acarreos
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class SiguienteMatricula {

    // Método para obtener la siguiente matrícula
    public static String siguienteMatricula(String matricula) {
        // Separar la parte numérica y la parte alfabética
        String numeros = matricula.substring(0, 4);
        String letras = matricula.substring(5, 8);

        // Incrementar la parte numérica
        int num = Integer.parseInt(numeros);
        num++;

        // Si llegamos a 10000, reiniciamos y aumentamos las letras
        if (num == 10000) {
            num = 0;
            letras = incrementarLetras(letras);
        }

        // Formatear la parte numérica con ceros a la izquierda
        String numerosSiguiente = String.format("%04d", num);
        return numerosSiguiente + " " + letras;
    }

    // Método para incrementar la parte alfabética
    private static String incrementarLetras(String letras) {
        char[] letrasArray = letras.toCharArray();
        int i = 2; // Empezamos desde la última letra

        while (i >= 0) {
            // Incrementar la letra actual
            letrasArray[i]++;

            // Si la letra supera 'Z', reiniciamos a 'B' y continuamos con la anterior
            if (letrasArray[i] > 'Z') {
                letrasArray[i] = 'B'; // Reiniciar a 'B'
                i--; // Pasar a la letra anterior
            } else if (letrasArray[i] == 'A' || letrasArray[i] == 'E' || letrasArray[i] == 'I' || letrasArray[i] == 'O' || letrasArray[i] == 'U') {
                // Si la letra es una vocal, saltamos a la siguiente letra
                letrasArray[i]++;
                if (letrasArray[i] > 'Z') {
                    letrasArray[i] = 'B'; // Reiniciar a 'B'
                    i--; // Pasar a la letra anterior
                }
            } else {
                // Si no es una vocal, hemos terminado
                break;
            }
        }

        return new String(letrasArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la primera matrícula
        String matricula = scanner.nextLine();

        while (!matricula.equals("9999 ZZZ")) {
            System.out.println(siguienteMatricula(matricula));
            matricula = scanner.nextLine(); // Leer la siguiente matrícula
        }

        scanner.close();
    }
}
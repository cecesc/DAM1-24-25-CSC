package ud4.ejercicios;

import java.util.Scanner;

public class SalvarLinceIberico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de descripciones de carreteras: ");
        int numCarreteras = scanner.nextInt(); // Leer el número de descripciones de carreteras
        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < numCarreteras; i++) {
            System.out.print("Ingrese la descripción de la carretera " + (i + 1) + ": ");
            String carreteraStr = scanner.nextLine(); // Leer la descripción de la carretera
            char[] carretera = carreteraStr.toCharArray(); // Convertir la cadena a un arreglo de caracteres
            int tunelesNecesarios = 0;
            int longitud = carretera.length;
            int j = 0;

            while (j < longitud) {
                // Si encontramos una sección que necesita protección
                if (carretera[j] == '.') {
                    tunelesNecesarios++; // Necesitamos un túnel
                    // Saltar las siguientes dos secciones, ya que el túnel protege 3 secciones
                    j += 3;
                } else {
                    j++; // Avanzar a la siguiente sección
                }
            }

            System.out.println("Número de túneles necesarios: " + tunelesNecesarios); // Imprimir el número de túneles necesarios
        }

        scanner.close();
    }
}
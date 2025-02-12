package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class FotoConMafalda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de personas
        System.out.print("Ingrese el número de personas que quieren hacerse una foto (0 para terminar): ");
        int n = scanner.nextInt();

        // Terminar si se encuentra un 0
        if (n == 0) {
            scanner.close();
            return;
        }

        // Arreglos para almacenar los personajes y su estado
        String[] personajes = new String[n];
        boolean[] ocupados = new boolean[7]; // Para los 7 personajes: Mafalda, Felipe, Manolito, Susanita, Miguelito, Libertad, Guille
        int fotos = 0;

        // Leer los personajes que cada persona quiere representar
        System.out.println("Ingrese los personajes que cada persona quiere representar:");
        for (int i = 0; i < n; i++) {
            personajes[i] = scanner.next();
        }

        // Procesar la cola de personajes
        for (int i = 0; i < n; i++) {
            String personaje = personajes[i];

            // Si la persona quiere ser Mafalda
            if (personaje.equals("Mafalda")) {
                // Verificar si hay al menos 2 personas más en la cola
                if (i + 2 < n) {
                    fotos++;
                    // Limpiar ocupados
                    Arrays.fill(ocupados, false);
                }
            } else {
                // Obtener el índice del personaje
                int index = getCharacterIndex(personaje);
                if (index != -1) {
                    // Si el personaje está ocupado, se ignora
                    if (!ocupados[index]) {
                        // Si no está ocupado, se toma la foto
                        ocupados[index] = true;
                        fotos++;
                    }
                }
            }
        }

        // Las personas que quedan sin hacerse la foto son las que no han sido ocupadas
        int sinFoto = n - fotos;

        // Imprimir el resultado
        System.out.println(fotos + " " + sinFoto);

        scanner.close();
    }

    // Método para obtener el índice del personaje
    private static int getCharacterIndex(String personaje) {
        switch (personaje) {
            case "Mafalda":
                return 0;
            case "Felipe":
                return 1;
            case "Manolito":
                return 2;
            case "Susanita":
                return 3;
            case "Miguelito":
                return 4;
            case "Libertad":
                return 5;
            case "Guille":
                return 6;
            default:
                return -1; // Personaje no válido
        }
    }
}
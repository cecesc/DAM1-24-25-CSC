package ud4.ejercicios;

import java.util.Scanner;

public class PanicoEnElTunel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la descripción del túnel
        System.out.println("Ingrese la descripción del túnel (ej. .T..T...):");
        String tunel = scanner.nextLine(); // Leer la descripción del túnel

        int longitud = tunel.length();
        int[] distanciaTelefonoIzquierda = new int[longitud];
        int[] distanciaTelefonoDerecha = new int[longitud];

        // Calcular la distancia al teléfono más cercano a la izquierda
        int ultimoTelefono = -1;
        for (int i = 0; i < longitud; i++) {
            if (tunel.charAt(i) == 'T') {
                ultimoTelefono = i;
                distanciaTelefonoIzquierda[i] = 0;
            } else {
                if (ultimoTelefono == -1) {
                    distanciaTelefonoIzquierda[i] = Integer.MAX_VALUE; // No hay teléfono a la izquierda
                } else {
                    distanciaTelefonoIzquierda[i] = i - ultimoTelefono;
                }
            }
        }

        // Calcular la distancia al teléfono más cercano a la derecha
        ultimoTelefono = -1;
        for (int i = longitud - 1; i >= 0; i--) {
            if (tunel.charAt(i) == 'T') {
                ultimoTelefono = i;
                distanciaTelefonoDerecha[i] = 0;
            } else {
                if (ultimoTelefono == -1) {
                    distanciaTelefonoDerecha[i] = Integer.MAX_VALUE; // No hay teléfono a la derecha
                } else {
                    distanciaTelefonoDerecha[i] = ultimoTelefono - i;
                }
            }
        }

        // Leer el número de consultas
        System.out.println("Ingrese el número de consultas:");
        int n = scanner.nextInt(); // Leer el número de consultas
        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese la posición de la consulta (1 a " + longitud + "):");
            int posicion = scanner.nextInt() - 1; // Convertir a índice 0
            scanner.nextLine(); // Consumir el salto de línea

            if (tunel.charAt(posicion) == 'T') {
                System.out.println("AQUI");
            } else {
                int distanciaIzquierda = distanciaTelefonoIzquierda[posicion];
                int distanciaDerecha = distanciaTelefonoDerecha[posicion];
                int distanciaSalidaIzquierda = posicion; // Distancia a la salida de la península
                int distanciaSalidaDerecha = longitud - 1 - posicion; // Distancia a la salida de las islas

                // Determinar la mejor dirección
                if (distanciaIzquierda < distanciaDerecha) {
                    System.out.println("PENINSULA");
                } else if (distanciaDerecha < distanciaIzquierda) {
                    System.out.println("ISLAS");
                } else {
                    // Distancias iguales
                    if (distanciaSalidaIzquierda < distanciaSalidaDerecha) {
                        System.out.println("PENINSULA");
                    } else if (distanciaSalidaDerecha < distanciaSalidaIzquierda) {
                        System.out.println("ISLAS");
                    } else {
                        // Empate total
                        System.out.println("PENINSULA");
                    }
                }
            }
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
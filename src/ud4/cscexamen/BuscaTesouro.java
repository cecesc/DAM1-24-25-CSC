//Autora: Celia Sanmartin Chapela
package ud4.cscexamen;
/* 
import java.util.Scanner;
import java.util.Random;

public class BuscaTesouro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Pedir dimensiones del mapa
        int filas = pedirEntero(sc, "Introduce el número de filas: ");
        int columnas = pedirEntero(sc, "Introduce el número de columnas: ");
        
        // Generar coordenadas del tesoro
        int tesoroFila = random.nextInt(filas);
        int tesoroColumna = random.nextInt(columnas);
        
        // Calcular intentos máximos (10% del total de casillas)
        int intentosMaximos = Math.max(1, (filas * columnas) / 10);
        int intentos = 0;
        boolean encontrado = false;
        boolean[][] intentosMapa = new boolean[filas][columnas];
        
        System.out.println("Tienes " + intentosMaximos + " intentos para encontrar el tesoro.");
        
        while (intentos < intentosMaximos && !encontrado) {
            // Pedir coordenadas al usuario
            int filaUsuario = pedirEntero(sc, "Introduce la fila: ", filas);
            int columnaUsuario = pedirEntero(sc, "Introduce la columna: ", columnas);
            
            intentos++;
            intentosMapa[filaUsuario][columnaUsuario] = true;
            
            if (filaUsuario == tesoroFila && columnaUsuario == tesoroColumna) {
                encontrado = true;
                System.out.println("¡Has encontrado el tesoro en " + intentos + " intentos!");
            } else {
                // Dar pista
                darPista(filaUsuario, columnaUsuario, tesoroFila, tesoroColumna);
                mostrarMapa(intentosMapa);
            }
        }
        
        if (!encontrado) {
            System.out.println("¡Se acabaron los intentos! El tesoro estaba en (" + tesoroFila + ", " + tesoroColumna + ").");
        }
        
        sc.close();
    }
    
    // Método para pedir un número entero con validación
    private static int pedirEntero(sc scanner, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) return numero;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número válido.");
            }
        }
    }
    
    private static int pedirEntero(sc scanner, String mensaje, int limite) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero >= 0 && numero < limite) return numero;
                System.out.println("Número fuera de rango.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número válido.");
            }
        }
    }
    
    // Método para dar una pista sobre la ubicación del tesoro
    private static void darPista(int fila, int columna, int tesoroFila, int tesoroColumna) {
        int difFila = tesoroFila - fila;
        int difColumna = tesoroColumna - columna;
        String direccion = "";
        
        if (difFila < 0) direccion += "norte";
        else if (difFila > 0) direccion += "sur";
        
        if (difColumna < 0) direccion += (direccion.isEmpty() ? "oeste" : "oeste");
        else if (difColumna > 0) direccion += (direccion.isEmpty() ? "este" : "este");
        
        String distancia = (Math.abs(difFila) <= 2 && Math.abs(difColumna) <= 2) ? "preto" : "lonxe";
        
        System.out.println("Pista: " + distancia + " cara o " + direccion);
    }
    
    // Método para mostrar el mapa con los intentos realizados
    private static void mostrarMapa(boolean[][] intentosMapa) {
        System.out.println("Mapa de intentos:");
        for (boolean[] fila : intentosMapa) {
            for (boolean intento : fila) {
                System.out.print(intento ? "X " : "- ");
            }
            System.out.println();
        }
    }
}
*/
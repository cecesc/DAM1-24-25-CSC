package ud4.ejercicios;

import java.util.Scanner;

public class BarDeJavier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definición de las categorías
        String[] categorias = {"D", "A", "M", "I", "C"};
        String[] nombresCategorias = {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"};
        double[] ingresos = new double[categorias.length]; // Ingresos por categoría
        double totalVentas = 0.0; // Total de ventas del día
        int totalTransacciones = 0; // Contador de transacciones

        // Leer las entradas
        System.out.println("Ingrese las categorías y los valores (formato: CATEGORIA VALOR). Ingrese 'N 0' para terminar:");

        while (true) {
            // Leer la primera entrada
            String categoria = scanner.next();
            double valor = scanner.nextDouble();

            // Verificar si se ingresó 'N 0' para terminar
            if (categoria.equals("N") && valor == 0) {
                break; // Fin de la entrada del día
            }

            // Actualizar ingresos
            int index = getCategoriaIndex(categoria);
            if (index != -1) {
                ingresos[index] += valor; // Actualizar ingresos por categoría
                totalVentas += valor; // Actualizar total de ventas
                totalTransacciones++; // Incrementar contador de transacciones
            } else {
                System.out.println("Categoría no válida. Intente de nuevo.");
            }
        }

        // Determinar la categoría con más y menos ingresos
        int categoriaMax = 0;
        int categoriaMin = 0;
        boolean empateMax = false;
        boolean empateMin = false;

        for (int i = 1; i < ingresos.length; i++) {
            if (ingresos[i] > ingresos[categoriaMax]) {
                categoriaMax = i;
                empateMax = false;
            } else if (ingresos[i] == ingresos[categoriaMax]) {
                empateMax = true;
            }

            if (ingresos[i] < ingresos[categoriaMin]) {
                categoriaMin = i;
                empateMin = false;
            } else if (ingresos[i] == ingresos[categoriaMin]) {
                empateMin = true;
            }
        }

        // Calcular la media de ventas
        double mediaVentas = totalTransacciones > 0 ? totalVentas / totalTransacciones : 0;
        double ventasComidas = ingresos[1]; // Ventas de comidas
        String superaMedia = (ventasComidas > mediaVentas) ? "SI" : "NO";

        // Imprimir resultado
        String nombreMax = empateMax ? "EMPATE" : nombresCategorias[categoriaMax];
        String nombreMin = empateMin ? "EMPATE" : nombresCategorias[categoriaMin];

        System.out.println(nombreMax + "#" + nombreMin + "#" + superaMedia);

        scanner.close(); // Cerrar el escáner al final
    }

    private static int getCategoriaIndex(String categoria) {
        switch (categoria) {
            case "D": return 0; // Desayunos
            case "A": return 1; // Comidas
            case "M": return 2; // Meriendas
            case "I": return 3; // Cenas
            case "C": return 4; // Copas
            default: return -1; // Categoría no válida
        }
    }
}
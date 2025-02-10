package ud4.ejercicios;

import java.util.Scanner;

public class BarDeJavier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer caso de prueba
        String categoria;
        double valor;

        // Leer el tamaño de la entrada
        categoria = scanner.next();
        valor = scanner.nextDouble();

        while (!(categoria.equals("N") && valor == 0)) { // Continuar mientras no se reciba "N 0"
            // Inicializar ingresos por categoría
            double[] ingresos = new double[5]; // 0: D, 1: A, 2: M, 3: I, 4: C
            double totalVentas = 0.0; // Total de ventas del día
            int totalTransacciones = 0; // Contador de transacciones

            // Procesar la primera entrada
            while (true) {
                // Actualizar ingresos
                switch (categoria) {
                    case "D":
                        ingresos[0] += valor; // Desayunos
                        break;
                    case "A":
                        ingresos[1] += valor; // Comidas
                        break;
                    case "M":
                        ingresos[2] += valor; // Meriendas
                        break;
                    case "I":
                        ingresos[3] += valor; // Cenas
                        break;
                    case "C":
                        ingresos[4] += valor; // Copas
                        break;
                }

                totalVentas += valor;
                totalTransacciones++;

                // Leer la siguiente entrada
                categoria = scanner.next();
                valor = scanner.nextDouble();

                if (categoria.equals("N") && valor == 0) {
                    break; // Fin de la entrada del día
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

            // Mapear categorías a nombres
            String nombreMax = getNombreCategoria(categoriaMax);
            String nombreMin = getNombreCategoria(categoriaMin);

            // Imprimir resultado
            if (empateMax) {
                nombreMax = "EMPATE";
            }
            if (empateMin) {
                nombreMin = "EMPATE";
            }

            System.out.println(nombreMax + "#" + nombreMin + "#" + superaMedia);

            // Leer la siguiente entrada para el siguiente día
            categoria = scanner.next();
            valor = scanner.nextDouble();
        }

        scanner.close(); // Cerrar el escáner al final
    }

    private static String getNombreCategoria(int categoria) {
        switch (categoria) {
            case 0: return "DESAYUNOS";
            case 1: return "COMIDAS";
            case 2: return "MERIENDAS";
            case 3: return "CENAS";
            case 4: return "COPAS";
            default: return "";
        }
    }
}